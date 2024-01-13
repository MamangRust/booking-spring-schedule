package com.sanedge.bookinghotel.service;

import com.sanedge.bookinghotel.domain.request.room.CreateRoomRequest;
import com.sanedge.bookinghotel.domain.request.room.UpdateRoomRequest;
import com.sanedge.bookinghotel.domain.response.MessageResponse;

public interface RoomService {
    MessageResponse findAll();

    MessageResponse findById(Long id);

    MessageResponse createRoom(CreateRoomRequest createRoomRequest);

    MessageResponse updateRoom(Long id, UpdateRoomRequest request);

    MessageResponse deleteRoom(Long id);
}
