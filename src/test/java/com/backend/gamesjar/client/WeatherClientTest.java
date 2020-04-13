package com.backend.gamesjar.client;

import com.backend.gamesjar.domain.WeatherDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherClientTest {


    @Mock
    WeatherClient weatherClient;

    @Test
    public void getInstance() {
    }

    @Test
    public void getWeather() {

        //When
        WeatherDto weatherDto;

        weatherClient.getWeather();

        //Then
       // weatherDto = weatherClient.getWeather();

       // System.out.println(weatherDto.getTemp());
    }
}