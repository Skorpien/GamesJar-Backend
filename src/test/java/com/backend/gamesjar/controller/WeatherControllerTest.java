package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.UserDto;
import com.backend.gamesjar.domain.WeatherDto;
import com.backend.gamesjar.facade.WeatherControllerFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherControllerFacade facade;

    @Test
    public void getWeather() throws Exception {
        //Given
        WeatherDto weatherDto = new WeatherDto("20.0", "30.0");
        Mockito.when(facade.getWeather()).thenReturn(weatherDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/weather").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.temp", is("20.0")))
                .andExpect(jsonPath("$.humidity", is("30.0")));
    }
}