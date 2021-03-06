/*
package com.backend.gamesjar.communicator;

import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.repository.CommunicatorRepository;
import com.backend.gamesjar.communicator.service.DialogService;
import com.backend.gamesjar.communicator.service.HistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommunicatorGuiTest {

   @Mock
   private CommunicatorGui communicatorGui;
   @Mock
   private HistoryService historyService;
   @Mock
   private CommunicatorRepository communicatorRepository;
   @Mock
   private DialogService dialogService;



    @Test
    public void sentMessage() throws Exception {

        //Given
        History history = new History(1L, "message");

        //When
        Mockito.when(dialogService.sentMessage(1L, "message")).thenReturn(history);
        Mockito.when(communicatorRepository.findById(1L)).thenReturn(java.util.Optional.of(history));
        Mockito.when(communicatorRepository.save(history)).thenReturn(history);



        communicatorGui.sentMessage(1L,"bob", "message");
    }
}
*/
