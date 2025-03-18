package com.cinema.booking.controller;

import com.cinema.booking.model.Booking;
import com.cinema.booking.repository.BookingRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

import static com.cinema.booking.properties.Urls.CANCEL_BOOKING;
import static com.cinema.booking.properties.Urls.CREATE_NEW_BOOKING;
import static com.cinema.booking.properties.Urls.GET_ALL_BOOKINGS;
import static com.cinema.booking.properties.Urls.GET_BOOKING_BY_BOOKING_ID;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;

    private static final String CREATE_NEW_BOOKING_VIEW_NAME = "create-new-booking-page";
    private static final String GET_ALL_BOOKINGS_VIEW_NAME = "view-booking-page";

    @GetMapping(CREATE_NEW_BOOKING)
    public ModelAndView getCreateNewBookingPage() {
        return new ModelAndView(CREATE_NEW_BOOKING_VIEW_NAME);
    }

    @PostMapping(CREATE_NEW_BOOKING)
    public ModelAndView createNewBooking(@RequestBody String selectMovie,
                                         @RequestParam String selectMovieTime,
                                         @RequestParam String seats,
                                         @RequestParam Integer numberOfTickets,
                                         @RequestParam Float totalPrice
                                         ) {
        Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setUserId(UUID.randomUUID().toString());
        booking.setMovieId(UUID.randomUUID().toString());
        booking.setSelectMovie(selectMovie);
        booking.setSelectMovieTime(selectMovieTime);
        booking.setSeats(seats);
        booking.setNumberOfTickets(numberOfTickets);
        booking.setTotalPrice(totalPrice);
        booking.setBookingStatus(null);
        booking.setBookingCreatedDate(LocalDateTime.now().toString());
        bookingRepository.save(booking);
        return new ModelAndView(CREATE_NEW_BOOKING_VIEW_NAME);
    }

    @GetMapping(GET_ALL_BOOKINGS)
    public ModelAndView getAllBooking() {
        return new ModelAndView(GET_ALL_BOOKINGS_VIEW_NAME);
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
