package com.example.weatherapplicationoutputgeneratorservice.service.impl;

import com.example.weatherapplicationoutputgeneratorservice.service.WeatherDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherDataGeneratorImpl implements WeatherDataGenerator {

    @Value("${weather.service.url}")
    String weatherServiceUrl;

    @Value("${weather.service.apikey}")
    String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Map<String, String> generateData(Map<String, String> cityMap) {
        Map<String, String> weatherInformationMap = new HashMap<>();
        String units = "metric";
        cityMap.keySet().stream().forEach(cityId -> {
            String url = weatherServiceUrl + "id=" + cityId + "&units=" + units + "&appid=" + apiKey;
            String jsonString = restTemplate.getForObject(url, String.class);
            weatherInformationMap.put(cityId, jsonString);
        });
        return weatherInformationMap;
    }
}