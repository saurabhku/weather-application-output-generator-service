package com.example.weatherapplicationoutputgeneratorservice.producer.impl;

import com.example.weatherapplicationoutputgeneratorservice.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message, String topicName) {
        log.info("Send message: " + message + " on topic: " + topicName);
        this.kafkaTemplate.send(topicName, message);
    }
}
