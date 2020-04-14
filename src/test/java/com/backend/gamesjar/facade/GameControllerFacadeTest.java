package com.backend.gamesjar.facade;

import com.backend.gamesjar.domain.*;
import com.backend.gamesjar.mapper.GameMapper;
import com.backend.gamesjar.service.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class GameControllerFacadeTest {

    @InjectMocks
    private GameControllerFacade facade;

    @Mock
    private DbService dbService;

    @Mock
    private GameMapper gameMapper;


    @Test
    public void gamesList() {
        //Given
        List<GameDto> gameDtoList = new ArrayList<>();
        gameDtoList.add(new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL));

        Mockito.when(gameMapper.mapToGameDtoList(dbService.getAllGames())).thenReturn(gameDtoList);

        //When
        List<GameDto> testList = facade.gamesList();

        //Then
        Assert.assertEquals(1, testList.size());

    }

    @Test
    public void getGame() throws GameNotFoundException {
        //Given
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);

        Mockito.when(gameMapper.mapToGameDto(dbService.getGame(1L))).thenReturn(gameDto);

        //When
        GameDto testGame = facade.getGame(1L);

        //Then
        Assert.assertEquals(1L, testGame.getId(), 0.001);
        Assert.assertEquals("name", testGame.getName());
    }

    @Test
    public void createGame() {
        //Given
        Game game = new Game(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);

        Mockito.when(dbService.saveGame(gameMapper.mapToGame(gameDto))).thenReturn(game);

        //When
        Game testGame = facade.createGame(gameDto);

        //Then
        Assert.assertEquals(1L, testGame.getId(), 0.001);
        Assert.assertEquals("name", testGame.getName());
    }

    @Test
    public void updateGame() {
        GameDto gameDto = new GameDto(1L, "name", PlayingTime.TWOHOURS, Category.AREACONTROL);

        Mockito.when(gameMapper.mapToGameDto(dbService.updateGame(gameMapper.mapToGame(gameDto)))).thenReturn(gameDto);

        //When
        GameDto testGame = facade.updateGame(gameDto);

        //Then
        Assert.assertEquals(1L, testGame.getId(), 0.001);
        Assert.assertEquals("name", testGame.getName());
    }
}