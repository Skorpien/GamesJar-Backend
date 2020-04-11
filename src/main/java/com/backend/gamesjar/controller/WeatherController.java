package com.backend.gamesjar.controller;

import com.backend.gamesjar.client.WeatherClient;
import com.backend.gamesjar.domain.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/gamesjar")
public class WeatherController {

    @Autowired
    private WeatherClient weatherClient;

    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    public WeatherDto getWeather() {
        //WeatherDto weather = weatherClient.getWeather();
            return weatherClient.getWeather();
       // System.out.println("temperature: " + weather.getTemp() + "\nhumidity: " + weather.getHumidity());
    }

}
