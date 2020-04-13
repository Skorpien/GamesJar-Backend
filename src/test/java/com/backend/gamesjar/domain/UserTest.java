package com.backend.gamesjar.domain;

import com.backend.gamesjar.communicator.domain.History;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void createUserTest() {

        //Given
        User user = new User(1L,"Bob", "pass");

        //When
        //Then
        Assert.assertEquals(1L, user.getId(), 0.001);
        Assert.assertEquals("Bob", user.getName());
        Assert.assertEquals("pass", user.getPassword());
    }

    @Test
    public void observerNotifyTest() {

        //Given
        User user = new User(1L,"Bob", "pass");
        Room room = new Room(2L, "gameRoom");
        History history = new History();

        //When
        history.setRoom(room);
        user.getRooms().add(room);
        history.registerObserver(user);

        history.setHistory("something");
        String message = user.getMessage();

        //Then
        Assert.assertEquals("There is new message in gameRoom room", message);
    }

}