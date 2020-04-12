package com.backend.gamesjar.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GameFilterTest {

    @InjectMocks
    private Room room;
    @InjectMocks
    private GameFilter gameFilter;

    private Game game1 = new Game(1L,"Lords", PlayingTime.TWOHOURS, Category.WORKERPLACEMENT);
    private Game game2 = new Game(2L,"Aeons", PlayingTime.TWOHOURS, Category.DECKBUILDING);
    private Game game3 = new Game(3L,"Res", PlayingTime.HALFHOUR, Category.TABLEAUBULDING);


    @Test
    public void search() {
        //Given
        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);
        gameList.add(game3);

        room.setGames(gameList);

        //When
        List<Game> finalList = gameFilter.search(room, "", PlayingTime.TWOHOURS, null);

        //Then
        Assert.assertEquals(2, finalList.size());
    }

    @Test
    public void randomizeTest() {

        //Given
        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);
        gameList.add(game3);

        //When
        Game game = gameFilter.randomize(gameList);
        int i = 0;
        for (Game searchGame:
             gameList) {
            if (searchGame.equals(game)) {
                i = 1;
                break;
            }
        }

        //Then
       Assert.assertEquals(1, i);
    }
}