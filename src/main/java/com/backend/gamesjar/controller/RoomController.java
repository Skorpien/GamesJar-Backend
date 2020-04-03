package com.backend.gamesjar.controller;

import com.backend.gamesjar.domain.RoomDto;
import com.backend.gamesjar.domain.RoomNotFoundException;
import com.backend.gamesjar.mapper.RoomMapper;
import com.backend.gamesjar.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/gamesjar")
public class RoomController {
    @Autowired
    DbService dbService;

    @Autowired
    RoomMapper roomMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/rooms")
    public List<RoomDto> roomsList() {
        return roomMapper.mapToRoomDtoList(dbService.getAllRooms());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rooms/{roomId}")
    public RoomDto getRoom(@PathVariable Long roomId) throws RoomNotFoundException {
        return roomMapper.mapToRoomDto(dbService.getRoom(roomId).orElseThrow(RoomNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rooms/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        dbService.deleteRoom(roomId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rooms", consumes = APPLICATION_JSON_VALUE)
    public void createRoom(@RequestBody RoomDto roomDto) {
        dbService.saveRoom(roomMapper.mapToRoom(roomDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rooms")
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return roomMapper.mapToRoomDto(dbService.saveRoom(roomMapper.mapToRoom(roomDto)));
    }
}
