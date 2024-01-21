package com.sanedge.bookinghotel.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.sanedge.bookinghotel.models.Room;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RoomRepositoryTest {
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void testFindAll() {
        List<Room> rooms = roomRepository.findAll();
        assertNotNull(rooms);
        assertFalse(rooms.isEmpty());
    }

    @Test
    public void testFindById() {
        Optional<Room> room = roomRepository.findById(1L);
        assertTrue(room.isPresent());
    }

    @Test
    public void testFindByRoomName() {
        Optional<Room> room = roomRepository.findByRoomName("yourRoomName");
        assertTrue(room.isPresent());
    }
}
