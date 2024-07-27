package com.cinema.booking.controller;

import com.cinema.booking.model.User;
import com.cinema.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController //@RestController tells Maven that the following class is a controller for a web application.
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login") //@GetMapping tells Maven that this code should be used to handle a specific GET request.
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }//This would just display the text "Greetings from Spring Boot!"

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    } //This will land to the home template

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
