package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "bookings")
@Setter
public class Booking {

    @MongoId
    private String bookingId;
    private String userId;
    private String movieId;
    private String selectMovie;
    private String selectMovieTime;
    private String seats;
    private Integer numberOfTickets;
    private Float totalPrice;
    private String bookingStatus;
    private String bookingCreatedDate;
}
