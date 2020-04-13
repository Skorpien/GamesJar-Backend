package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.Room;
import com.backend.gamesjar.domain.RoomDto;
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
public class RoomMapperTest {

    @InjectMocks
    private RoomMapper roomMapper;

    @Test
    public void mapToRoom() {

        //Given
        RoomDto roomDto = new RoomDto(1L, "room");

        //When
        Room room = roomMapper.mapToRoom(roomDto);

        //Then
        Assert.assertEquals(roomDto.getId(), room.getId());
        Assert.assertEquals(roomDto.getName(), room.getName());
    }

    @Test
    public void mapToRoomDto() {

        //Given
        Room room = new Room(1L, "room");

        //When
        RoomDto roomDto = roomMapper.mapToRoomDto(room);

        //Then
        Assert.assertEquals(room.getId(), roomDto.getId());
        Assert.assertEquals(room.getName(), roomDto.getName());
    }

    @Test
    public void mapToRoomDtoList() {

        //Given
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room());
        roomList.add(new Room());

        //When
        List<RoomDto> roomDtoList = roomMapper.mapToRoomDtoList(roomList);

        //Then
        Assert.assertEquals(2, roomDtoList.size());
    }
}