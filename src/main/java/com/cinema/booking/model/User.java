package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Setter;

@Document(collection = "users")
@Setter
public class User {

    private String userId;
    private String username;
    private String password;
    private String email;
    private String name;
    private Integer phoneNumber;
    private String address;
}
