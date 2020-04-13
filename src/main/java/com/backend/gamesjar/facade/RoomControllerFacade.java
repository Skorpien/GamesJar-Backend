package com.backend.gamesjar.facade;

import com.backend.gamesjar.domain.RoomDto;
import com.backend.gamesjar.domain.RoomNotFoundException;
import com.backend.gamesjar.mapper.RoomMapper;
import com.backend.gamesjar.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RoomControllerFacade {

    @Autowired
    private DbService dbService;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDto> roomsList() {
        return roomMapper.mapToRoomDtoList(dbService.getAllRooms());
    }

    public RoomDto getRoom(Long roomId) throws RoomNotFoundException {
        return roomMapper.mapToRoomDto(dbService.getRoom(roomId).orElseThrow(RoomNotFoundException::new));
    }

    public void deleteRoom(Long roomId) {
        dbService.deleteRoom(roomId);
    }

    public void createRoom(RoomDto roomDto) {
        dbService.saveRoom(roomMapper.mapToRoom(roomDto));
    }

    public RoomDto updateRoom(RoomDto roomDto) {
        return roomMapper.mapToRoomDto(dbService.saveRoom(roomMapper.mapToRoom(roomDto)));
    }
}
