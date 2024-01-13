package com.sanedge.bookinghotel.service;

import com.sanedge.bookinghotel.domain.request.booking.CreateBookingRequest;
import com.sanedge.bookinghotel.domain.request.booking.UpdateBookingRequest;
import com.sanedge.bookinghotel.domain.response.MessageResponse;

public interface BookingService {
    MessageResponse findAll();

    MessageResponse findById(Long id);

    MessageResponse createBooking(Long userId, CreateBookingRequest request);

    MessageResponse updateBooking(Long id, Long userId, UpdateBookingRequest request);

    MessageResponse deleteById(Long id);

}
