package com.sanedge.bookinghotel.service;

import com.sanedge.bookinghotel.domain.request.booking.CheckInRequest;
import com.sanedge.bookinghotel.domain.response.MessageResponse;

public interface CheckService {
    MessageResponse checkInOrder(CheckInRequest request);

    MessageResponse checkOrder(String orderId);

    MessageResponse checkOutOrder(String orderId);
}
