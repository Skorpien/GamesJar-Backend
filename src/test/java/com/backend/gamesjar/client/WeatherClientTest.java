/*
package com.backend.gamesjar.client;

import com.backend.gamesjar.config.WeatherConfig;
import com.backend.gamesjar.domain.Weather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherClientTest {

    @Mock
    private WeatherClient weatherClient;

    @Mock
    private WeatherConfig weatherConfig;

    @Mock
    private WeatherSpecifier weatherSpecifier;

    @Before
    public void init() {
        when(weatherConfig.getWeatherEndpoint()).thenReturn("http://test.com");
        when(weatherConfig.getWeatherCity()).thenReturn("city");
        when(weatherConfig.getWeatherKey()).thenReturn("xxx");
    }

    @Test
    public void testGetWeather() {
        //Given
        Weather weather = new Weather();
        weather.setTemp("20.0");
        weather.setHumidity("30.0");


        //When
        when(weatherSpecifier.specificResult(weather, "http://test.com/q=city&appid=xxx&units=metric")).thenReturn(weather);

        Weather testWeather = weatherClient.getWeather();

        //Then
//        Assert.assertEquals("20.0", testWeather.getTemp());
 //       Assert.assertEquals("30.0", testWeather.getHumidity());
    }



    @Test
    public void getMyWeather() {

        //Given
        WeatherClient weatherClient = new WeatherClient();
    }
}*/
