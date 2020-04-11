package com.backend.gamesjar.communicator.service;

import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private String history = "";

    public String getHistory() {
        return history;
    }

    public void addHistory(String text) {
        this.history += text + System.lineSeparator();
    }
}