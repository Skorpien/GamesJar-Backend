package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.Weather;
import com.backend.gamesjar.domain.WeatherDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class WeatherMapperTest {

    @InjectMocks
    private WeatherMapper weatherMapper;

    @Test
    public void mapToWeather() {

        //Given
        WeatherDto weatherDto = new WeatherDto("20.0", "30.0");

        //When
        Weather weather = weatherMapper.mapToWeather(weatherDto);

        //Then
        Assert.assertEquals(weatherDto.getTemp(), weather.getTemp());
        Assert.assertEquals(weatherDto.getHumidity(), weather.getHumidity());
    }

    @Test
    public void mapToWeatherDto() {

        //Given
        Weather weather = new Weather("20.0", "30.0");

        //When
        WeatherDto weatherDto = weatherMapper.mapToWeatherDto(weather);

        //Then
        Assert.assertEquals(weather.getTemp(), weatherDto.getTemp());
        Assert.assertEquals(weather.getHumidity(), weatherDto.getHumidity());
    }
}