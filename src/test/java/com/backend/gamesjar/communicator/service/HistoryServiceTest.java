package com.backend.gamesjar.communicator.service;

import com.backend.gamesjar.communicator.CommunicatorRepository;
import com.backend.gamesjar.communicator.domain.History;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTest {

    @InjectMocks
    HistoryService historyService;
    @Mock
    CommunicatorRepository communicatorRepository;

    @Test
    public void getHistory() {

        //Given
        History history = new History(1L, "history");

        //When
        String historyCheck = history.getHistory();

        //Then
        Assert.assertEquals("history", historyCheck);

    }

    @Test
    public void addHistory() throws Exception {

        //Given
        History history = new History(1L, "");

        //When
        Mockito.when(communicatorRepository.findById(1L)).thenReturn(java.util.Optional.of(history));

        historyService.addHistory("one", 1L);
        historyService.addHistory("two", 1L);
        historyService.addHistory("three", 1L);

        String historyCheck = history.getHistory();

        //Then
        Assert.assertEquals("one"+System.lineSeparator()+"two"+System.lineSeparator()+"three"+System.lineSeparator(), historyCheck);

    }


    @Test
    public void getAllHistories() {

        //Given
        List<History> historyList = new ArrayList<>();
        historyList.add(new History());
        historyList.add(new History());

        //When
        Mockito.when(communicatorRepository.findAll()).thenReturn(historyList);
        int historyListSize = historyService.getAllHistories().size();

        //Then
        Assert.assertEquals(2, historyListSize);

    }

    @Test
    public void createHistory() {

        //Given
        History history = new History();

        //When
        Mockito.when(communicatorRepository.save(history)).thenReturn(history);
        History historyCheck = historyService.createHistory(history);

        //Then
        Assert.assertNotNull(historyCheck);
    }

}