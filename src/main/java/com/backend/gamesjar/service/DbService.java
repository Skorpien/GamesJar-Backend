package com.backend.gamesjar.service;

import com.backend.gamesjar.domain.Game;
import com.backend.gamesjar.domain.Room;
import com.backend.gamesjar.domain.User;
import com.backend.gamesjar.repository.GameRepository;
import com.backend.gamesjar.repository.RoomRepository;
import com.backend.gamesjar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGame(final Long id) {
        return gameRepository.findById(id);
    }

    public Game saveGame(final Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(final Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(final Long id) {
        gameRepository.deleteById(id);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoom(final Long id) {
        return roomRepository.findById(id);
    }

    public Room saveRoom(final Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(final Long id) {
        roomRepository.deleteById(id);
    }
}
