package com.cinema.booking.controller;

import com.cinema.booking.model.User;
import com.cinema.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Show login page
    @GetMapping("/")
    public ModelAndView showLoginPage() {
        return new ModelAndView("Login"); // Login template
    }

    // Show home page after successful login
    @GetMapping("/Welcome")
    public ModelAndView homePageAfterSuccessLogin() {
        return new ModelAndView("Welcome"); // Home template
    }

    // Show registration page
    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("Register"); // Registration template
    }

    // Handle user registration
    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam String username, @RequestParam String password) {
        // Create a new User object and save it to the repository
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        // After registration, redirect to the login page
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/login")
    public ModelAndView loginUser() {
        // After "successful" login, redirect to the home page
        return new ModelAndView("redirect:/Welcome");
    }
}
