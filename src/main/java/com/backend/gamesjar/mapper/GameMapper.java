package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.Game;
import com.backend.gamesjar.domain.GameDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameMapper {
    public Game mapToGame(final GameDto gameDto) {
        return new Game(
                gameDto.getId(),
                gameDto.getName(),
                gameDto.getTime(),
                gameDto.getCategories()
        );
    }

    public GameDto mapToGameDto(final Game game) {
        return new GameDto(
                game.getId(),
                game.getName(),
                game.getTime(),
                game.getCategories()
        );
    }

    public List<GameDto> mapToGameDtoList(final List<Game> games) {
        return games.stream()
                .map(game -> new GameDto(game.getId(), game.getName(), game.getTime(), game.getCategories()))
                .collect(Collectors.toList());
    }
}
