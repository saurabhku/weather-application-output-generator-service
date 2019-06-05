package com.example.weatherapplicationoutputgeneratorservice.producer;

public interface KafkaProducer {

    public void sendMessage(String message, String topicName);
}
