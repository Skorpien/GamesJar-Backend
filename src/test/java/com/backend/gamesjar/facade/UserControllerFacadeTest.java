package com.backend.gamesjar.facade;

import com.backend.gamesjar.domain.*;
import com.backend.gamesjar.mapper.UserMapper;
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
public class UserControllerFacadeTest {

    @InjectMocks
    private UserControllerFacade facade;

    @Mock
    private DbService dbService;

    @Mock
    private UserMapper userMapper;

    @Test
    public void userList() {
        //Given
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto(1L, "name", "password"));

        Mockito.when(userMapper.mapToUserDtoList(dbService.getAllUsers())).thenReturn(userDtoList);

        //When
        List<UserDto> testList = facade.userList();

        //Then
        Assert.assertEquals(1, testList.size());
    }

    @Test
    public void getUser() throws UserNotFoundException {
        //Given
        UserDto userDto = new UserDto(1L, "name", "password");

        Mockito.when(userMapper.mapToUserDto(dbService.getUser(1L))).thenReturn(userDto);

        //When
        UserDto testUser = facade.getUser(1L);

        //Then
        Assert.assertEquals(1L, testUser.getId(), 0.001);
        Assert.assertEquals("name", testUser.getName());
        Assert.assertEquals("password", testUser.getPassword());
    }

    @Test
    public void createUser() {
        //Given
        User user = new User(1L, "name", "password");
        UserDto userDto = new UserDto(1L, "name", "password");

        Mockito.when(dbService.saveUser(userMapper.mapToUser(userDto))).thenReturn(user);

        //When
        User testUser = facade.createUser(userDto);

        //Then
        Assert.assertEquals(1L, testUser.getId(), 0.001);
        Assert.assertEquals("name", testUser.getName());
        Assert.assertEquals("password", testUser.getPassword());
    }

    @Test
    public void updateUser() {
        UserDto userDto = new UserDto(1L, "name", "password");

        Mockito.when(userMapper.mapToUserDto(dbService.saveUser(userMapper.mapToUser(userDto)))).thenReturn(userDto);

        //When
        UserDto testUser = facade.updateUser(userDto);

        //Then
        Assert.assertEquals(1L, testUser.getId(), 0.001);
        Assert.assertEquals("name", testUser.getName());
        Assert.assertEquals("password", testUser.getPassword());
    }
}