package com.backend.gamesjar.communicator.controller;

import com.backend.gamesjar.communicator.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/gamesjar")
public class ConnectionController {
    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/history", method = RequestMethod.PUT)
    public void sentText(@RequestBody String text) {
        historyService.addHistory(text);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getHistory() {
        return historyService.getHistory();
    }
}
