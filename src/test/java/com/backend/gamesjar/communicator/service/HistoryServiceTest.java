package com.backend.gamesjar.communicator.service;

import com.backend.gamesjar.communicator.repository.CommunicatorRepository;
import com.backend.gamesjar.communicator.domain.History;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTest {

    @InjectMocks
    HistoryService historyService;
    @Mock
    CommunicatorRepository communicatorRepository;

    @Test
    public void getHistory() {

        //Given
        Optional<History> history = Optional.of(new History(1L, "history"));

        //When
        Mockito.when(communicatorRepository.findById(1L)).thenReturn(history);
        Optional<History> historyCheck = historyService.getHistory(1L);

        //Then
        Assert.assertEquals(history, historyCheck);

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