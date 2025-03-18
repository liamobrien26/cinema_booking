package com.cinema.booking.repository;

import com.cinema.booking.model.Booking;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking,String> {
    Optional<Booking> findByBookingId(String bookingId);

}
