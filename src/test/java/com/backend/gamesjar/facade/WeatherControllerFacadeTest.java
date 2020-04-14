package com.backend.gamesjar.facade;

import com.backend.gamesjar.client.WeatherClient;
import com.backend.gamesjar.domain.Weather;
import com.backend.gamesjar.domain.WeatherDto;
import com.backend.gamesjar.mapper.UserMapper;
import com.backend.gamesjar.mapper.WeatherMapper;
import com.backend.gamesjar.service.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerFacadeTest {

    @InjectMocks
    private WeatherControllerFacade facade;

    @Mock
    private WeatherClient weatherClient;


    @Test
    public void getWeather() {
        //Given
        WeatherDto weatherDto = new WeatherDto("20.0", "30.0");

        Mockito.when(weatherClient.getWeather()).thenReturn(weatherDto);

        //When
        WeatherDto testWeather = facade.getWeather();

        //Then
        Assert.assertEquals("20.0", testWeather.getTemp());
        Assert.assertEquals("30.0", testWeather.getHumidity());
    }
}