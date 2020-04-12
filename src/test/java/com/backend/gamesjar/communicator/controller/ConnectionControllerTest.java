/*
package com.backend.gamesjar.communicator.controller;

import com.backend.gamesjar.communicator.service.DialogService;
import com.backend.gamesjar.communicator.service.HistoryService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ConnectionController.class)
public class ConnectionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DialogService dialogService;

    @MockBean
    HistoryService historyService;

    @Test
    public void sentText() throws Exception {

    }

    @Test
    public void getHistory() throws Exception {
        String text = "message";

        Mockito.when(historyService.getHistory()).thenReturn(text);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/history").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }
}*/
