package com.cinema.booking.controller;

import com.cinema.booking.model.Booking;
import com.cinema.booking.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.cinema.booking.properties.Urls.CANCEL_BOOKING;
import static com.cinema.booking.properties.Urls.CREATE_NEW_BOOKING;
import static com.cinema.booking.properties.Urls.GET_ALL_BOOKINGS;
import static com.cinema.booking.properties.Urls.GET_BOOKING_BY_BOOKING_ID;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping(CREATE_NEW_BOOKING)
    public String createNewBooking(@RequestParam String bookingId,
                                   @RequestParam String userId,
                                   @RequestParam Integer movieId,
                                   @RequestParam String seats,
                                   @RequestParam Integer numberOfTickets,
                                   @RequestParam Float totalPrice,
                                   @RequestParam String bookingStatus,
                                   @RequestParam Integer bookingCreatedDate) {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        booking.setUserId(userId);
        booking.setMovieId(movieId);
        booking.setSeats(seats);
        booking.setNumberOfTickets(numberOfTickets);
        booking.setTotalPrice(totalPrice);
        booking.setBookingStatus(bookingStatus);
        booking.setBookingCreatedDate(bookingCreatedDate);
        bookingRepository.save(booking);
        return CREATE_NEW_BOOKING;
    }

    @GetMapping(GET_ALL_BOOKINGS)
    public String getAllBooking() {
        return GET_ALL_BOOKINGS;
    }

    @GetMapping(GET_BOOKING_BY_BOOKING_ID)
    public String getBookingByBookingId() {
        return GET_BOOKING_BY_BOOKING_ID;
    }

    @PostMapping(CANCEL_BOOKING)
    public String cancelBooking() {
        return CANCEL_BOOKING;
    }
}
