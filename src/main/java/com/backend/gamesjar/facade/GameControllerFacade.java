package com.backend.gamesjar.facade;

import com.backend.gamesjar.domain.GameDto;
import com.backend.gamesjar.domain.GameNotFoundException;
import com.backend.gamesjar.mapper.GameMapper;
import com.backend.gamesjar.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameControllerFacade {

    @Autowired
    private DbService dbService;

    @Autowired
    private GameMapper gameMapper;

    public List<GameDto> gamesList() {
        return gameMapper.mapToGameDtoList(dbService.getAllGames());
    }

    public GameDto getGame(Long gameId) throws GameNotFoundException {
        return gameMapper.mapToGameDto(dbService.getGame(gameId).orElseThrow(GameNotFoundException::new));
    }


    public void deleteGame(Long gameId) {
        dbService.deleteGame(gameId);
    }

    public void createGame(GameDto gameDto) {
        dbService.saveGame(gameMapper.mapToGame(gameDto));
    }

    public GameDto updateGame(GameDto gameDto) {
        return gameMapper.mapToGameDto(dbService.updateGame(gameMapper.mapToGame(gameDto)));
    }
}
