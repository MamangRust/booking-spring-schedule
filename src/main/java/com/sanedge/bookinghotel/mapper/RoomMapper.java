package com.sanedge.bookinghotel.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.sanedge.bookinghotel.domain.response.room.RoomResponse;
import com.sanedge.bookinghotel.models.Room;

public class RoomMapper {
    public static RoomResponse toRoomResponse(Room room) {
        RoomResponse roomResponse = new RoomResponse();
        roomResponse.setId(room.getId());
        roomResponse.setRoomName(room.getRoomName());
        roomResponse.setRoomCapacity(room.getRoomCapacity());
        roomResponse.setPhoto(room.getPhoto());
        return roomResponse;
    }

    public static List<RoomResponse> toRoomResponseList(List<Room> roomList) {
        return roomList.stream().map(RoomMapper::toRoomResponse).collect(Collectors.toList());
    }
}
