package com.backend.gamesjar.observer;

import com.backend.gamesjar.communicator.domain.History;

public interface Observer {
    String update(History history);
}
