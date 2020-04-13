package com.backend.gamesjar.client;

import com.backend.gamesjar.config.WeatherConfig;
import com.backend.gamesjar.domain.Weather;
import com.backend.gamesjar.domain.WeatherDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Component
@Getter
public class WeatherClient {

    @Autowired
    private WeatherConfig weatherConfig;


    public Weather getWeather() {
        URI url = UriComponentsBuilder.fromHttpUrl(weatherConfig.getWeatherEndpoint())
                .queryParam("q", weatherConfig.getWeatherCity())
                .queryParam("appid", weatherConfig.getWeatherKey())
                .queryParam("units", "metric").build().encode().toUri();
        WeatherSpecifier weatherSpecifier = new WeatherSpecifier();
        Weather weather = new Weather();
        weather = weatherSpecifier.specificResult(weather, url.toString());

        if(weather != null) {
            return weather;
        }
        return new Weather();
    }
}
