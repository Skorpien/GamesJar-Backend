package com.backend.gamesjar.communicator.service;

import com.backend.gamesjar.communicator.CommunicatorRepository;
import com.backend.gamesjar.communicator.domain.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DialogService {
    @Autowired
    CommunicatorRepository communicatorRepository;

    public void sentMessage(Long historyId, String infoToSent) {
        RestTemplate rest = new RestTemplate();
        rest.exchange(
                String.format("http://localhost:8083/v1/gamesjar/history/%s?text=%s", historyId, infoToSent),
                HttpMethod.PUT,
                HttpEntity.EMPTY,
                String.class);
    }
}