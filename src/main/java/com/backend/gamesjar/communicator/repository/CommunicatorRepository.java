package com.backend.gamesjar.communicator.repository;

import com.backend.gamesjar.communicator.domain.History;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommunicatorRepository extends CrudRepository<History, Long> {
    @Override
    History save(History message);

    @Override
    Optional<History> findById(Long historyId);

    @Override
    List<History> findAll();

    @Override
    void deleteById(Long historyId);
}
