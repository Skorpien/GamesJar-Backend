package com.backend.gamesjar.service;

import com.backend.gamesjar.domain.*;
import com.backend.gamesjar.repository.GameRepository;
import com.backend.gamesjar.repository.RoomRepository;
import com.backend.gamesjar.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService service;

    @Mock
    private UserRepository userRepository;
    @Mock
    private GameRepository gameRepository;
    @Mock
    private RoomRepository roomRepository;

    @Test
    public void getAllUsers() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "name", "password"));

        //When
        Mockito.when(userRepository.findAll()).thenReturn(users);

        //Then
        List<User> userList = service.getAllUsers();

        assertEquals(users.get(0).getId(), userList.get(0).getId());
        assertEquals(users.get(0).getName(), userList.get(0).getName());
        assertEquals(users.get(0).getPassword(), userList.get(0).getPassword());
    }

    @Test
    public void getUser() throws UserNotFoundException {
        //Given
        User user = new User(1L, "name", "password");

        //When
        Mockito.when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        //Then
        User testUser = service.getUser(1L);

        assertEquals(user.getId(), testUser.getId());
        assertEquals(user.getName(), testUser.getName());
        assertEquals(user.getPassword(), testUser.getPassword());
    }

    @Test
    public void saveUser() {
        //Given
        User user = new User(1L, "name", "password");

        //When
        Mockito.when(userRepository.save(user)).thenReturn(user);

        //Then
        User testUser = service.saveUser(user);

        assertEquals(user.getId(), testUser.getId());
        assertEquals(user.getName(), testUser.getName());
        assertEquals(user.getPassword(), testUser.getPassword());
    }

    @Test
    public void deleteUser() {
        //Given
        Long userId = 1L;

        //When
        service.deleteUser(userId);

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(userId);
    }

    @Test
    public void getAllGames() {
        //Given
        List<Game> games = new ArrayList<>();
        games.add(new Game(1L, "title", PlayingTime.HOUR, Category.ADVENTURE));

        //When
        Mockito.when(gameRepository.findAll()).thenReturn(games);

        //Then
        List<Game> gameList= service.getAllGames();

        assertEquals(games.get(0).getId(), gameList.get(0).getId());
        assertEquals(games.get(0).getName(), gameList.get(0).getName());
        assertEquals(games.get(0).getTime(), gameList.get(0).getTime());
        assertEquals(games.get(0).getCategories(), gameList.get(0).getCategories());
    }

    @Test
    public void getGame() throws GameNotFoundException {
        //Given
        Game game = new Game(1L, "title", PlayingTime.HOUR, Category.ADVENTURE);

        //When
        Mockito.when(gameRepository.findById(1L)).thenReturn(java.util.Optional.of(game));

        //Then
        Game testGame = service.getGame(1L);

        assertEquals(game.getId(), testGame.getId());
        assertEquals(game.getName(), testGame.getName());
        assertEquals(game.getTime(), testGame.getTime());
        assertEquals(game.getCategories(), testGame.getCategories());
    }

    @Test
    public void saveGame() {
        //Given
        Game game = new Game(1L, "title", PlayingTime.HOUR, Category.ADVENTURE);

        //When
        Mockito.when(gameRepository.save(game)).thenReturn(game);

        //Then
        Game testGame = service.saveGame(game);

        assertEquals(game.getId(), testGame.getId());
        assertEquals(game.getName(), testGame.getName());
        assertEquals(game.getTime(), testGame.getTime());
        assertEquals(game.getCategories(), testGame.getCategories());
    }


    @Test
    public void deleteGame() {
        //Given
        Long gameId = 1L;

        //When
        service.deleteGame(gameId);

        //Then
        Mockito.verify(gameRepository, Mockito.times(1)).deleteById(gameId);
    }

    @Test
    public void getAllRooms() {
        //Given
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1L, "room"));

        //When
        Mockito.when(roomRepository.findAll()).thenReturn(rooms);

        //Then
        List<Room> roomList = service.getAllRooms();

        assertEquals(rooms.get(0).getId(), roomList.get(0).getId());
        assertEquals(rooms.get(0).getName(), roomList.get(0).getName());
    }

    @Test
    public void getRoom() throws RoomNotFoundException {
        //Given
        Room room = new Room(1L, "room");

        //When
        Mockito.when(roomRepository.findById(1L)).thenReturn(java.util.Optional.of(room));

        //Then
        Room testRoom = service.getRoom(1L);

        assertEquals(room.getId(), testRoom.getId());
        assertEquals(room.getName(), testRoom.getName());
    }

    @Test
    public void saveRoom() {
        //Given
        Room room = new Room(1L, "room");

        //When
        Mockito.when(roomRepository.save(room)).thenReturn(room);

        //Then
        Room testRoom = service.saveRoom(room);

        assertEquals(room.getId(), testRoom.getId());
        assertEquals(room.getName(), testRoom.getName());
    }

    @Test
    public void deleteRoom() {
        //Given
        Long roomId = 1L;

        //When
        service.deleteRoom(roomId);

        //Then
        Mockito.verify(roomRepository, Mockito.times(1)).deleteById(roomId);
    }
}