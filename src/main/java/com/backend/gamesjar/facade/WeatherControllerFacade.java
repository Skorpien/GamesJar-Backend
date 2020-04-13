package com.backend.gamesjar.facade;

import com.backend.gamesjar.client.WeatherClient;
import com.backend.gamesjar.domain.WeatherDto;
import com.backend.gamesjar.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherControllerFacade {

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private WeatherMapper weatherMapper;

    public WeatherDto getWeather() {
        return weatherMapper.mapToWeatherDto(weatherClient.getWeather());
    }
}
