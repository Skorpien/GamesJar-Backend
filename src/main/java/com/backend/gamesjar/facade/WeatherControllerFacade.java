package com.backend.gamesjar.facade;

import com.backend.gamesjar.client.WeatherClient;
import com.backend.gamesjar.domain.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherControllerFacade {

    @Autowired
    private WeatherClient weatherClient;

    public WeatherDto getWeather() {
        return weatherClient.getWeather();
    }
}
