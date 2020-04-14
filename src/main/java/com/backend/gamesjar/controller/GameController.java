package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.Game;
import com.backend.gamesjar.domain.GameDto;
import com.backend.gamesjar.domain.GameNotFoundException;
import com.backend.gamesjar.facade.GameControllerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/gamesjar")
public class GameController {
    @Autowired
    private GameControllerFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "/games")
    public List<GameDto> gamesList() {
        return facade.gamesList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/games/{gameId}")
    public GameDto getGame(@PathVariable Long gameId) throws GameNotFoundException {
        return facade.getGame(gameId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/games/{gameId}")
    public void deleteGame(@PathVariable Long gameId) {
        facade.deleteGame(gameId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/games", consumes = APPLICATION_JSON_VALUE)
    public Game createGame(@RequestBody GameDto gameDto) {
        return facade.createGame(gameDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/games")
    public GameDto updateGame(@RequestBody GameDto gameDto) {
        return facade.updateGame(gameDto);
    }
}
