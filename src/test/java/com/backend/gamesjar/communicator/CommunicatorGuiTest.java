package com.backend.gamesjar.communicator;

import com.backend.gamesjar.communicator.controller.ConnectionController;
import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.service.DialogService;
import com.backend.gamesjar.communicator.service.HistoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CommunicatorGuiTest {

   @Mock
   CommunicatorGui communicatorGui;
   @Mock
   HistoryService historyService;
   @Mock
   DialogService dialogService;
   @Mock
   CommunicatorRepository communicatorRepository;


    @Test
    public void sentMessage() throws Exception {
        History history = new History(1L, "");
//        Mockito.when(communicatorRepository.findById(1L)).thenReturn(java.util.Optional.of(history));

        communicatorGui.sentMessage(1L,"bob", "message");
        System.out.println(historyService.getHistory(1L));
    }
}
