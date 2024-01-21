package com.sanedge.bookinghotel.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.sanedge.bookinghotel.domain.response.booking.BookingDetailsResponse;
import com.sanedge.bookinghotel.domain.response.booking.CheckOutResponse;
import com.sanedge.bookinghotel.models.Booking;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookingRepositoryTest {
    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testFindAll() {
        List<Booking> bookings = bookingRepository.findAll();
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
    }

    @Test
    public void testFindById() {
        Optional<Booking> booking = bookingRepository.findById(1L);
        assertTrue(booking.isPresent());
    }

    @Test
    public void testFindByOrderId() {
        String orderId = "yourOrderId";
        Optional<Booking> booking = bookingRepository.findByOrderId(orderId);
        assertTrue(booking.isPresent());
    }

    @Test
    public void testFindBookingDetailsByOrderId() {
        String orderId = "yourOrderId";
        Optional<BookingDetailsResponse> response = bookingRepository.findBookingDetailsByOrderId(orderId);
        assertTrue(response.isPresent());
    }

    @Test
    public void testFindCheckoutDetailsByOrderId() {
        String orderId = "yourOrderId";
        Optional<CheckOutResponse> response = bookingRepository.findCheckoutDetailsByOrderId(orderId);
        assertTrue(response.isPresent());
    }

    @Test
    public void testFindBookingsByBookingTime() {
        LocalDateTime dateNow = LocalDateTime.now();
        List<Booking> bookings = bookingRepository.findBookingsByBookingTime(dateNow);
        assertNotNull(bookings);
    }
}
