package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.User;
import com.backend.gamesjar.domain.UserDto;
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
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void mapToUser() {

        //Given
        UserDto userDto = new UserDto(1L,"name", "password");

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        Assert.assertEquals(userDto.getId(), user.getId());
        Assert.assertEquals(userDto.getName(), user.getName());
        Assert.assertEquals(userDto.getPassword(), user.getPassword());
    }

    @Test
    public void mapToUserDto() {

        //Given
        User user = new User(1L,"name", "password");

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        Assert.assertEquals(user.getId(), userDto.getId());
        Assert.assertEquals(user.getName(), userDto.getName());
        Assert.assertEquals(user.getPassword(), userDto.getPassword());
    }

    @Test
    public void mapToUserDtoList() {

        //Given
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());

        //When
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userList);

        //Then
        Assert.assertEquals(2, userDtoList.size());
    }
}