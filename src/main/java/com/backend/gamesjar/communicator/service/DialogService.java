package com.backend.gamesjar.communicator.service;

import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.repository.CommunicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DialogService {

    @Autowired
    private CommunicatorRepository communicatorRepository;

    public History sentMessage(Long historyId, String infoToSent) throws Exception {
        /*RestTemplate rest = new RestTemplate();
        rest.exchange(
                String.format("http://localhost:8083/v1/gamesjar/history/%s?text=%s", historyId, infoToSent),
                HttpMethod.PUT,
                HttpEntity.EMPTY,
                String.class);*/
        Optional<History> message = communicatorRepository.findById(historyId);
        message.get().setHistory(message.get().getHistory() + infoToSent + System.lineSeparator());
        return communicatorRepository.save(message.orElseThrow(Exception::new));
    }
}