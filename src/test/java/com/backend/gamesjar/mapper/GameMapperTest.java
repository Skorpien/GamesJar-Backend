package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.Category;
import com.backend.gamesjar.domain.Game;
import com.backend.gamesjar.domain.GameDto;
import com.backend.gamesjar.domain.PlayingTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class GameMapperTest {

    @InjectMocks
    private GameMapper gameMapper;

    @Test
    public void mapToGame() {

        //Given
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);

        //When
        Game game = gameMapper.mapToGame(gameDto);

        //Then
        Assert.assertEquals(gameDto.getId(), game.getId());
        Assert.assertEquals(gameDto.getName(), game.getName());
        Assert.assertEquals(gameDto.getTime(), game.getTime());
        Assert.assertEquals(gameDto.getCategories(), game.getCategories());

    }

    @Test
    public void mapToGameDto() {

        //Given
        Game game = new Game(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);

        //When
        GameDto gameDto = gameMapper.mapToGameDto(game);

        //Then
        Assert.assertEquals(game.getId(), gameDto.getId());
        Assert.assertEquals(game.getName(), gameDto.getName());
        Assert.assertEquals(game.getTime(), gameDto.getTime());
        Assert.assertEquals(game.getCategories(), gameDto.getCategories());
    }

    @Test
    public void mapToGameDtoList() {

        //Given
        List<Game> gameList = new ArrayList<>();
        gameList.add(new Game());
        gameList.add(new Game());

        //When
        List<GameDto> gameDtoList = gameMapper.mapToGameDtoList(gameList);

        //Then
        Assert.assertEquals(2, gameDtoList.size());
    }
}