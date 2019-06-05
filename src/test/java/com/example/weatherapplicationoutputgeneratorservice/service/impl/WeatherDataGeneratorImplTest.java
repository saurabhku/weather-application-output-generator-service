package com.example.weatherapplicationoutputgeneratorservice.service.impl;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDataGeneratorImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherDataGeneratorImpl weatherDataServiceImpl = new WeatherDataGeneratorImpl();

    @Test
    public void testGenerateData() {

        Map<String, String> cityMap = new HashMap<>();
        cityMap.put("2643741", "City of London");
        cityMap.put("2988507", "Paris");
        String resultString1 = "dummyvalueForLondon";
        String resultString2 = "dummyvalueForParis";

        Mockito
                .when(restTemplate.getForObject("nullid=2643741&units=metric&appid=null", String.class))
          .thenReturn(resultString1);
        Mockito
                .when(restTemplate.getForObject("nullid=2988507&units=metric&appid=null", String.class))
                .thenReturn(resultString2);
        Map<String, String> resultMap = weatherDataServiceImpl.generateData(cityMap);
        Assert.assertEquals(resultString1, resultMap.get("2643741"));
        Assert.assertEquals(resultString2, resultMap.get("2988507"));

    }
}