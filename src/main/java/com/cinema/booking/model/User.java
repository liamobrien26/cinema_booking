package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    private String userId;
    private String username;
    private String password;
    private String email;
    private String name;
    private Integer phoneNumber;
    private String address;

    public void setUserId(String userId) {this.userId = userId;}
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {this.email = email;}
    public void setName(String name) {this.name = name;}
    public void setPhoneNumber(Integer phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setAddress(String address) {this.address = address;}
}
