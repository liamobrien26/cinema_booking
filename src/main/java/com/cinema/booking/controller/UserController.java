package com.cinema.booking.controller;

import com.cinema.booking.model.User;
import com.cinema.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.cinema.booking.properties.Urls.HOME_PAGE;
import static com.cinema.booking.properties.Urls.LOGIN;
import static com.cinema.booking.properties.Urls.LOG_OUT;
import static com.cinema.booking.properties.Urls.PROFILE;
import static com.cinema.booking.properties.Urls.REGISTER;
import static com.cinema.booking.properties.Urls.WELCOME_PAGE;

//Manage user-related functionalities (login, register, profile)

@RestController //@RestController tells Maven that the following class is a controller for a web application.
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(REGISTER)
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam String name,
                               @RequestParam Integer phoneNumber,
                               @RequestParam String address) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        userRepository.save(user);
        return LOGIN;
    }

    @PostMapping(LOGIN) //@GetMapping tells Maven that this code should be used to handle a specific GET request.
    public String login() {
        return WELCOME_PAGE;
    }

    @GetMapping(PROFILE)
    public String getProfile() {
        return PROFILE;
    }

    @PostMapping(LOG_OUT)
    public String logout() {
        return HOME_PAGE;
    }
}