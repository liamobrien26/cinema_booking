package com.cinema.booking.controller;

import com.cinema.booking.model.UserPO;
import com.cinema.booking.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

import static com.cinema.booking.properties.Urls.HOME_PAGE;
import static com.cinema.booking.properties.Urls.LANDING_PAGE;
import static com.cinema.booking.properties.Urls.LOGIN;
import static com.cinema.booking.properties.Urls.PROFILE;
import static com.cinema.booking.properties.Urls.REGISTER;


@RestController //@RestController tells Maven that the following class is a controller for a web application.
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String HOME_PAGE_VIEW_NAME = "home-page";
    private static final String LOGIN_PAGE_VIEW_NAME = "login-page";
    private static final String REGISTER_PAGE_VIEW_NAME = "register-page";
    private static final String LANDING_PAGE_VIEW_NAME = "landing-page";
    private static final String PROFILE_PAGE_VIEW_NAME = "profile-page";
    private static final String PROFILE_PAGE_MODEL_NAME = "profile";
    private static final String CSRF_TOKEN_KEY = "token";

    @GetMapping(HOME_PAGE) //Land to first page on webpage
    public ModelAndView homePage() {
        return new ModelAndView(HOME_PAGE_VIEW_NAME);
    }

    @GetMapping(LOGIN)
    public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) String error, CsrfToken csrfToken) {
        ModelAndView modelAndView = new ModelAndView(LOGIN_PAGE_VIEW_NAME);

        // If there's an error, pass the error message to the model
        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password");
        }

        modelAndView.addObject(CSRF_TOKEN_KEY, csrfToken.getToken());
        return modelAndView;
    }


    @GetMapping(REGISTER)
    public ModelAndView getRegisterPage(CsrfToken csrfToken) {
        return new ModelAndView(REGISTER_PAGE_VIEW_NAME,
                CSRF_TOKEN_KEY, csrfToken.getToken());
    }

    @PostMapping(REGISTER)
    public ModelAndView registerUser(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String email,
                                     @RequestParam String name,
                                     @RequestParam Integer phoneNumber,
                                     @RequestParam String address) {
        UserPO userPO = new UserPO();
        userPO.setUserId(UUID.randomUUID().toString());
        userPO.setUsername(username);
        // Hash the password using the PasswordEncoder before saving it
        userPO.setPassword(passwordEncoder.encode(password));  // Use the PasswordEncoder to hash the password
        userPO.setEmail(email);
        userPO.setName(name);
        userPO.setPhoneNumber(phoneNumber);
        userPO.setAddress(address);
        userRepository.save(userPO);
        return new ModelAndView(HOME_PAGE_VIEW_NAME);
    }

//    @GetMapping(PROFILE)
//    public ModelAndView getProfile(CsrfToken csrfToken) {
//        return new ModelAndView(PROFILE_PAGE_VIEW_NAME,
//                PROFILE_PAGE_MODEL_NAME,
//                userRepository.findAll());
//    }

    @GetMapping(PROFILE)
    public ModelAndView getProfile(CsrfToken csrfToken) {
        ModelAndView modelAndView = new ModelAndView(PROFILE_PAGE_VIEW_NAME); //Create a ModelAndView Object
//userRepository.findAll() → Fetches all user records from the database.
//PROFILE_PAGE_MODEL_NAME ("profile") → This is the key used in the template.
//The template can now access user data like {{profile.username}}
        modelAndView.addObject(PROFILE_PAGE_MODEL_NAME, userRepository.findAll());
        modelAndView.addObject(CSRF_TOKEN_KEY, csrfToken.getToken());

        return modelAndView; //Spring MVC renders the template with the data I added to the model.
    }

    @GetMapping(LANDING_PAGE)
    public ModelAndView getLandingPage(CsrfToken csrfToken) {
        return new ModelAndView(LANDING_PAGE_VIEW_NAME, "token", csrfToken.getToken());
    }
}