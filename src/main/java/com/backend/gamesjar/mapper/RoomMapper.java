package com.backend.gamesjar.mapper;

import com.backend.gamesjar.domain.Game;
import com.backend.gamesjar.domain.GameDto;
import com.backend.gamesjar.domain.Room;
import com.backend.gamesjar.domain.RoomDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {
    public Room mapToRoom(final RoomDto roomDto) {
        return new Room(
                roomDto.getName()
        );
    }

    public RoomDto mapToRoomDto(final Room room) {
        return new RoomDto(
                room.getName()
        );
    }

    public List<RoomDto> mapToRoomDtoList(final List<Room> rooms) {
        return rooms.stream()
                .map(room -> new RoomDto(room.getName()))
                .collect(Collectors.toList());
    }
}
