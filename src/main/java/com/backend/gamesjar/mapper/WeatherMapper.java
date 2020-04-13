package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.Weather;
import com.backend.gamesjar.domain.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public Weather mapToWeather(final WeatherDto weatherDto) {
        return new Weather(
                weatherDto.getTemp(),
                weatherDto.getHumidity()
        );
    }

    public WeatherDto mapToWeatherDto(final Weather weather) {
        return new WeatherDto(
                weather.getTemp(),
                weather.getHumidity()
        );
    }
}
