package com.cinema.booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.cinema.booking.properties.Urls.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt is a strong password algorithm
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HOME_PAGE, REGISTER).permitAll()  // Allow access to home page and register page
                        .anyRequest().authenticated() // All other requests need to be logged in
                )
                .formLogin(form -> form
                        .loginPage(LOGIN).permitAll()  // Custom login page
                        .defaultSuccessUrl(LANDING_PAGE, true)  // Force redirect to LANDING_PAGE after login
                        .failureUrl(LOGIN_ERROR_URL)  // Redirect to login page with error parameter on failure
                )
                .logout(logout -> logout
                        .logoutUrl(LOG_OUT)  // URL for logout
                        .logoutSuccessUrl(HOME_PAGE)  // Redirect to home page after successful logout
                        .permitAll()  // Allow all users to access logout endpoint without restrictions
                );
        return http.build();
    }
}