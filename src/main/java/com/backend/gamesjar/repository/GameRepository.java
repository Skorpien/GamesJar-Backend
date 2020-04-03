package com.backend.gamesjar.repository;

import com.backend.gamesjar.domain.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {
    @Override
    List<Game> findAll();

    @Override
    Game save(Game game);

    @Override
    Optional<Game> findById(Long id);

    @Override
    void deleteById(Long id);
}
