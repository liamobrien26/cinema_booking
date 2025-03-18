package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "bookings")
@Setter
@Getter
public class Booking {

    private String bookingId;
    private String userId;
    private Integer movieId;
    private String seats;
    private Integer numberOfTickets;
    private Float totalPrice;
    private String bookingStatus;
    private Integer bookingCreatedDate;

}
