package com.backend.gamesjar.facade;

import com.backend.gamesjar.domain.UserDto;
import com.backend.gamesjar.domain.UserNotFoundException;
import com.backend.gamesjar.mapper.UserMapper;
import com.backend.gamesjar.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserControllerFacade {

    @Autowired
    private DbService dbService;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> userList () {
        return userMapper.mapToUserDtoList(dbService.getAllUsers());
    }

    public UserDto getUser(Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    public void deleteUser(Long userId) {
        dbService.deleteUser(userId);
    }

    public void createUser (UserDto userDto) {
        dbService.saveUser(userMapper.mapToUser(userDto));
    }

    public UserDto updateUser (UserDto userDto) {
        return userMapper.mapToUserDto(dbService.saveUser(userMapper.mapToUser(userDto)));
    }
}
