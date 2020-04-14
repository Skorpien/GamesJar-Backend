package com.backend.gamesjar.facade;

import com.backend.gamesjar.domain.*;
import com.backend.gamesjar.mapper.RoomMapper;
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
public class RoomControllerFacadeTest {

    @InjectMocks
    private RoomControllerFacade facade;

    @Mock
    private DbService dbService;

    @Mock
    private RoomMapper roomMapper;

    @Test
    public void roomsList() {
        //Given
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDtoList.add(new RoomDto(1L, "name"));

        Mockito.when(roomMapper.mapToRoomDtoList(dbService.getAllRooms())).thenReturn(roomDtoList);

        //When
        List<RoomDto> testList = facade.roomsList();

        //Then
        Assert.assertEquals(1, testList.size());
    }

    @Test
    public void getRoom() throws RoomNotFoundException {
        //Given
        RoomDto roomDto = new RoomDto(1L, "name");

        Mockito.when(roomMapper.mapToRoomDto(dbService.getRoom(1L))).thenReturn(roomDto);

        //When
        RoomDto testRoom = facade.getRoom(1L);

        //Then
        Assert.assertEquals(1L, testRoom.getId(), 0.001);
        Assert.assertEquals("name", testRoom.getName());
    }

    @Test
    public void createRoom() {
        //Given
        Room room = new Room(1L, "name");
        RoomDto roomDto = new RoomDto(1L, "name");

        Mockito.when(dbService.saveRoom(roomMapper.mapToRoom(roomDto))).thenReturn(room);

        //When
        Room testRoom = facade.createRoom(roomDto);

        //Then
        Assert.assertEquals(1L, testRoom.getId(), 0.001);
        Assert.assertEquals("name", testRoom.getName());
    }

    @Test
    public void updateRoom() {
        RoomDto roomDto = new RoomDto(1L, "name");

        Mockito.when(roomMapper.mapToRoomDto(dbService.saveRoom(roomMapper.mapToRoom(roomDto)))).thenReturn(roomDto);

        //When
        RoomDto testRoom = facade.updateRoom(roomDto);

        //Then
        Assert.assertEquals(1L, testRoom.getId(), 0.001);
        Assert.assertEquals("name", testRoom.getName());
    }
}