package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.Category;
import com.backend.gamesjar.domain.GameDto;
import com.backend.gamesjar.domain.PlayingTime;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class GameController {
    @RequestMapping(method = RequestMethod.GET, value = "/games")
    public List<GameDto> gamesList() {
        return new ArrayList<>();
    }

    public GameDto getGame(Long gameId) {
        return new GameDto(1L, "game", PlayingTime.HOUR, Arrays.asList(Category.ADVENTURE, Category.COOP));
    }
}
