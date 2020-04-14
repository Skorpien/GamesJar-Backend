package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.*;
import com.backend.gamesjar.facade.GameControllerFacade;
import com.backend.gamesjar.mapper.GameMapper;
import com.backend.gamesjar.service.DbService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameControllerFacade facade;

    @Test
    public void gamesList() throws Exception {
        //Given
        List<GameDto> gameDtoList = new ArrayList<>();
        gameDtoList.add(new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL));
        Mockito.when(facade.gamesList()).thenReturn(gameDtoList);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/games").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void getGame() throws Exception {
        //Given
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);
        Mockito.when(facade.getGame(1L)).thenReturn(gameDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/games/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.time", is("TWOHOURS")))
                .andExpect(jsonPath("$.categories", is("AREACONTROL")));
    }

    @Test
    public void deleteGame() throws Exception {
        //Given
        List<GameDto> gameDtoList = new ArrayList<>();
        gameDtoList.add(new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL));

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/gamesjar/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createGame() throws Exception {
        //Given
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);
        Game game = new Game(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);
        Mockito.when(facade.createGame(gameDto)).thenReturn(game);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(gameDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/gamesjar/games")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.time", is("TWOHOURS")))
                .andExpect(jsonPath("$.categories", is("AREACONTROL")));
    }

    @Test
    public void updateGame() throws Exception {
        //Given
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);
        Mockito.when(facade.updateGame(gameDto)).thenReturn(gameDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(gameDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.put("/v1/gamesjar/games")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.time", is("TWOHOURS")))
                .andExpect(jsonPath("$.categories", is("AREACONTROL")));
    }
}