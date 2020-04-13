package com.backend.gamesjar.communicator.service;

import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.repository.CommunicatorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DialogServiceTest {

    @InjectMocks
    private DialogService dialogService;
    @Mock
    private CommunicatorRepository communicatorRepository;

    @Test
    public void sentMessage() throws Exception {

        //Given
        History history = new History(1L, "message");

        //When
        Mockito.when(communicatorRepository.findById(1L)).thenReturn(java.util.Optional.of(history));
        Mockito.when(communicatorRepository.save(history)).thenReturn(history);

        //Then
        History testHistory = dialogService.sentMessage(1L, "message");

        Assert.assertEquals(history.getId(), testHistory.getId());
        Assert.assertEquals(history.getHistory(), testHistory.getHistory());


    }
}