package com.sanedge.bookinghotel.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sanedge.bookinghotel.domain.response.booking.BookingDetailsResponse;
import com.sanedge.bookinghotel.domain.response.booking.CheckOutResponse;
import com.sanedge.bookinghotel.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAll();

    Optional<Booking> findById(Long id);

    @Query("SELECT b FROM Booking b JOIN FETCH b.user u WHERE b.orderId = :orderId")
    Optional<Booking> findByOrderId(String orderId);

    @Query("SELECT new com.sanedge.bookinghotel.domain.response.booking.BookingDetailsResponse(" +
            "b.orderId, b.totalPerson, b.bookingTime, u.email, r.roomName, r.roomCapacity, r.photo, r.roomStatus) " +
            "FROM Booking b " +
            "JOIN b.user u " +
            "JOIN b.room r " +
            "WHERE b.orderId = :orderId")
    Optional<BookingDetailsResponse> findBookingDetailsByOrderId(String orderId);

    @Query("SELECT new com.sanedge.bookinghotel.domain.response.booking.CheckOutResponse(b.orderId, b.room.id, b.checkOutTime, u.email) "
            +
            "FROM Booking b " +
            "JOIN b.user u " +
            "WHERE b.orderId = :orderId")
    Optional<CheckOutResponse> findCheckoutDetailsByOrderId(String orderId);

    @Query("SELECT b FROM Booking b JOIN b.user u WHERE b.bookingTime = :dateNow")
    List<Booking> findBookingsByBookingTime(@Param("dateNow") LocalDateTime dateNow);
}
