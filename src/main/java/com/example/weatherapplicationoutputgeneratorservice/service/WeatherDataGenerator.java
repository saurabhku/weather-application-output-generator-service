package com.example.weatherapplicationoutputgeneratorservice.service;

import java.util.Map;

public interface WeatherDataGenerator {
    public Map<String, String> generateData(Map<String, String> cityList);
}
