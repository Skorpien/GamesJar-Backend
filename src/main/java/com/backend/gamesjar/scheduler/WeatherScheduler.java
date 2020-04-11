package com.backend.gamesjar.scheduler;

import com.backend.gamesjar.controller.WeatherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {

    @Autowired
    private WeatherController weatherController;

    @Scheduled(cron = "* */10 * * * *")
    public void refreshWeather() {
        weatherController.getWeather();
        System.out.println("SCHEDULE");
    }

}
