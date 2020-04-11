package com.backend.gamesjar.client;

import com.backend.gamesjar.domain.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Component
public class WeatherClient {

    @Value("${weather.api.endpoint.prod}")
    private String weatherEndpoint;

    @Value("${weather.app.key}")
    private String weatherKey;

    @Value("${weather.app.city}")
    private String weatherCity;


    public WeatherDto getWeather() {
        URI url = UriComponentsBuilder.fromHttpUrl(weatherEndpoint)
                .queryParam("q", weatherCity)
                .queryParam("appid", weatherKey)
                .queryParam("units", "metric").build().encode().toUri();
        WeatherSpecifier weatherSpecifier = new WeatherSpecifier();
        WeatherDto weather = new WeatherDto();
        weather = weatherSpecifier.specificResult(weather, url.toString());



        if(weather != null) {
            return weather;
        }
        return new WeatherDto();
    }
}
