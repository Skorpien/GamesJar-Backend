package com.backend.gamesjar.controller;

import com.backend.gamesjar.client.WeatherClient;
import com.backend.gamesjar.domain.Weather;
import com.backend.gamesjar.domain.WeatherDto;
import com.backend.gamesjar.facade.WeatherControllerFacade;
import com.backend.gamesjar.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/gamesjar")
public class WeatherController {

    @Autowired
    private WeatherControllerFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    public WeatherDto getWeather() {
           return facade.getWeather();
    }

}
