package com.backend.gamesjar.communicator.service;

import com.backend.gamesjar.communicator.repository.CommunicatorRepository;
import com.backend.gamesjar.communicator.domain.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    private CommunicatorRepository communicatorRepository;

    public Optional<History> getHistory(final Long historyId) {
        return communicatorRepository.findById(historyId);
    }

    public History addHistory(String text, final Long historyId) throws Exception {
        Optional<History> message = communicatorRepository.findById(historyId);
        message.get().setHistory(message.get().getHistory() + text + System.lineSeparator());
        return communicatorRepository.save(message.orElseThrow(Exception::new));
    }

    public History createHistory(final History history) {
        return communicatorRepository.save(history);
    }

    public List<History> getAllHistories() {
        return communicatorRepository.findAll();
    }

    public void deleteHistory(final Long historyId) {
        communicatorRepository.deleteById(historyId);
    }
}
