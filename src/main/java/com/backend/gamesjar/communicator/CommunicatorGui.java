package com.backend.gamesjar.communicator;

import com.backend.gamesjar.communicator.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunicatorGui {
    @Autowired
    private DialogService dialogService;

    public void sentMessage(String userName, String message) {
            dialogService.sentMessage("localhost", "8082", userName + ": " + message);
    }

}
