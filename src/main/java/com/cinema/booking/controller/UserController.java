package com.cinema.booking.controller;

import com.cinema.booking.model.UserPO;
import com.cinema.booking.repository.UserRepository;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

import static com.cinema.booking.properties.Urls.HOME_PAGE;
import static com.cinema.booking.properties.Urls.LANDING_PAGE;
import static com.cinema.booking.properties.Urls.LOGIN;
import static com.cinema.booking.properties.Urls.LOG_OUT;
import static com.cinema.booking.properties.Urls.PROFILE;
import static com.cinema.booking.properties.Urls.REGISTER;


@RestController //@RestController tells Maven that the following class is a controller for a web application.
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private static final String HOME_PAGE_VIEW_NAME = "home-page";
    private static final String LOGOUT_VIEW_NAME = "logout-page";

    private static final String LOGIN_PAGE_VIEW_NAME = "login-page";

    private static final String REGISTER_PAGE_VIEW_NAME = "register-page";

    private static final String LANDING_PAGE_VIEW_NAME = "landing-page";

    private static final String PROFILE_PAGE_VIEW_NAME = "profile-page";
    private static final String PROFILE_PAGE_MODEL_NAME = "profile";

    @GetMapping(HOME_PAGE) //Land to first page on webpage
    public ModelAndView homePage() {
        return new ModelAndView(HOME_PAGE_VIEW_NAME);
    }

    @GetMapping(LOGIN)
    public ModelAndView getLoginPage(CsrfToken csrfToken) {
        return new ModelAndView(LOGIN_PAGE_VIEW_NAME,
                                "token", csrfToken.getToken());
    }
//    NO LONGER REQUIRED AS 'WebSecurityConfig' has now thr POST logic on line 28

//    @PostMapping(LOGIN) //@GetMapping tells Maven that this code should be used to handle a specific GET request.
//    public ModelAndView login() {
//        return new ModelAndView(LANDING_PAGE_VIEW_NAME) ;
//    }
//    NO LONGER REQUIRED AS 'WebSecurityConfig' has now thr POST logic on line 28

    @GetMapping(REGISTER)
    public ModelAndView getRegisterPage(CsrfToken csrfToken) {
        return new ModelAndView(REGISTER_PAGE_VIEW_NAME,
                                "token", csrfToken.getToken());
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
        userPO.setPassword(password);
        userPO.setEmail(email);
        userPO.setName(name);
        userPO.setPhoneNumber(phoneNumber);
        userPO.setAddress(address);
        userRepository.save(userPO);
        return new ModelAndView(HOME_PAGE_VIEW_NAME) ;
    }

    @GetMapping(PROFILE)
    public ModelAndView getProfile() {
        return new ModelAndView(PROFILE_PAGE_VIEW_NAME,
                                PROFILE_PAGE_MODEL_NAME,
                                userRepository.findAll());
    }

    @GetMapping(LANDING_PAGE)
    public ModelAndView getLandingPage(CsrfToken csrfToken) {
        return new ModelAndView(LANDING_PAGE_VIEW_NAME, "token", csrfToken.getToken());
    }


    @GetMapping(LOG_OUT)
    public ModelAndView getLogOut(CsrfToken csrfToken) {
        return new ModelAndView(LOGOUT_VIEW_NAME, "token", csrfToken.getToken());
    }

    @PostMapping(LOG_OUT)
    public ModelAndView logOut(CsrfToken csrfToken) {
        return new ModelAndView(HOME_PAGE_VIEW_NAME,"token", csrfToken.getToken());
    }
}