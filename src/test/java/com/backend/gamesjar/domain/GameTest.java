package com.backend.gamesjar.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Test
    public void gameTest() {
        Game game = new Game(1L, "Lords", PlayingTime.HOUR, Category.ADVENTURE);

        Assert.assertEquals(1L, game.getId(), 0.001);
        Assert.assertEquals("Lords", game.getName());
        Assert.assertEquals(PlayingTime.HOUR, game.getTime());
        Assert.assertEquals(Category.ADVENTURE, game.getCategories());
    }

}