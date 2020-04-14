package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.*;
import com.backend.gamesjar.facade.RoomControllerFacade;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RoomController.class)
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomControllerFacade facade;

    @Test
    public void RoomsList() throws Exception {
        //Given
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDtoList.add(new RoomDto(1L, "name"));
        Mockito.when(facade.roomsList()).thenReturn(roomDtoList);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/rooms").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void getRoom() throws Exception {
        //Given
        RoomDto roomDto = new RoomDto(1L, "name");
        Mockito.when(facade.getRoom(1L)).thenReturn(roomDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/rooms/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")));
    }

    @Test
    public void deleteRoom() throws Exception {
        //Given
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDtoList.add(new RoomDto(1L, "name"));

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/gamesjar/rooms/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createRoom() throws Exception {
        //Given
        RoomDto roomDto = new RoomDto(1L, "name");
        Room room = new Room(1L, "name");
        Mockito.when(facade.createRoom(roomDto)).thenReturn(room);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(roomDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/gamesjar/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")));
    }

    @Test
    public void updateRoom() throws Exception {
        //Given
        RoomDto roomDto = new RoomDto(1L, "name");
        Mockito.when(facade.updateRoom(roomDto)).thenReturn(roomDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(roomDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.put("/v1/gamesjar/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")));
    }
}