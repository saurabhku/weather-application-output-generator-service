package com.example.weatherapplicationoutputgeneratorservice;

import com.example.weatherapplicationoutputgeneratorservice.producer.KafkaProducer;
import com.example.weatherapplicationoutputgeneratorservice.service.WeatherDataGenerator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WeatherApplicationOutputGeneratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplicationOutputGeneratorServiceApplication.class, args);

	}

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
}




