package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

//PO stands for Persistence Object-you are going to store all the internal changed structure of the object
// Persistent objects (POs) are Java objects used to write and read data to/from the database

@Document(collection = "users")
@Setter
@Getter
public class UserPO {

    private String userId;
    private String username;
    private String password;
    private String email;
    private String name;
    private Integer phoneNumber;
    private String address;
}
//todo add user field
