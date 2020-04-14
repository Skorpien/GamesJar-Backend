package com.backend.gamesjar.communicator.controller;

import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.domain.HistoryDto;
import com.backend.gamesjar.communicator.mapper.HistoryMapper;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(ConnectionController.class)
public class ConnectionControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private HistoryService historyService;

    @MockBean
    private HistoryMapper historyMapper;

    @Test
    public void getHistory() throws Exception {
        HistoryDto historyDto = new HistoryDto(1L, "history");

        Mockito.when(historyMapper.mapToHistoryDto(historyService.getHistory(1L))).thenReturn(historyDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/gamesjar/history/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.history", Matchers.is("history")));
    }
}
