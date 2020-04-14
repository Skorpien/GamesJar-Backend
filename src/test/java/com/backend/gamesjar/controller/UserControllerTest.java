package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.User;
import com.backend.gamesjar.domain.UserDto;
import com.backend.gamesjar.facade.UserControllerFacade;
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
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserControllerFacade facade;

    @Test
    public void userList() throws Exception {
        //Given
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto(1L, "name", "password"));
        Mockito.when(facade.userList()).thenReturn(userDtoList);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void getUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "name", "password");
        Mockito.when(facade.getUser(1L)).thenReturn(userDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.password", is("password")));
    }

    @Test
    public void deleteUser() throws Exception {
        //Given
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto(1L, "name", "password"));

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/gamesjar/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "name", "password");
        User user = new User(1L, "name", "password");
        Mockito.when(facade.createUser(userDto)).thenReturn(user);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/gamesjar/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.password", is("password")));
    }

    @Test
    public void updateUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "name", "password");
        Mockito.when(facade.updateUser(userDto)).thenReturn(userDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders.put("/v1/gamesjar/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.password", is("password")));
    }
}