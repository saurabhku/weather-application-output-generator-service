package com.example.weatherapplicationoutputgeneratorservice.consumer.impl;

import com.example.weatherapplicationoutputgeneratorservice.consumer.KafkaConsumer;
import com.example.weatherapplicationoutputgeneratorservice.producer.KafkaProducer;
import com.example.weatherapplicationoutputgeneratorservice.service.WeatherDataGenerator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaConsumerImpl implements KafkaConsumer {

    @Autowired
    WeatherDataGenerator weatherDataGenerator;

    @Autowired
    KafkaProducer kafkaProducer;

    @Value( "${kafka.output.topic}")
    String kafkaOutputTopic;

    @Override
    @KafkaListener(topics = "${kafka.input.topic}", groupId = "group_id")
    public void consume(String message) {
        Gson gson = new Gson();
        Map<String, String> map = gson.fromJson(message, Map.class);

        String message1 = weatherDataGenerator.generateData(map).toString();
        kafkaProducer.sendMessage(message1, kafkaOutputTopic);
    }
}