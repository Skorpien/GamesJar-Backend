package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.GameDto;
import com.backend.gamesjar.domain.GameNotFoundException;
import com.backend.gamesjar.mapper.GameMapper;
import com.backend.gamesjar.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/gamesjar")
public class GameController {
    @Autowired
    private DbService dbService;

    @Autowired
    private GameMapper gameMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/games")
    public List<GameDto> gamesList() {
        return gameMapper.mapToGameDtoList(dbService.getAllGames());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/games/{gameId}")
    public GameDto getGame(@PathVariable Long gameId) throws GameNotFoundException {
        return gameMapper.mapToGameDto(dbService.getGame(gameId).orElseThrow(GameNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/games/{gameId}")
    public void deleteGame(@PathVariable Long gameId) {
        dbService.deleteGame(gameId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/games", consumes = APPLICATION_JSON_VALUE)
    public void createGame(@RequestBody GameDto gameDto) {
        dbService.saveGame(gameMapper.mapToGame(gameDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/games")
    public GameDto updateGame(@RequestBody GameDto gameDto) {
        return gameMapper.mapToGameDto(dbService.saveGame(gameMapper.mapToGame(gameDto)));
    }
}
