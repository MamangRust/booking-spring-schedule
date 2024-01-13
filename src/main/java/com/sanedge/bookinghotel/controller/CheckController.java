package com.sanedge.bookinghotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanedge.bookinghotel.domain.request.booking.CheckInRequest;
import com.sanedge.bookinghotel.domain.response.MessageResponse;
import com.sanedge.bookinghotel.service.CheckService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/check")
public class CheckController {

    @Autowired
    CheckService checkService;

    @PostMapping("/check-in")
    public ResponseEntity<MessageResponse> checkIn(@Valid @RequestBody CheckInRequest request) {
        MessageResponse room = checkService.checkInOrder(request);

        return ResponseEntity.ok(room);

    }

    @GetMapping("/check-order/{orderId}")
    public ResponseEntity<MessageResponse> checkOrder(@PathVariable String orderId) {
        MessageResponse response = checkService.checkOrder(orderId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/check-out/{orderId}")
    public ResponseEntity<MessageResponse> checkOut(@PathVariable String orderId) {
        MessageResponse response = checkService.checkOutOrder(orderId);
        return ResponseEntity.ok(response);
    }

}
