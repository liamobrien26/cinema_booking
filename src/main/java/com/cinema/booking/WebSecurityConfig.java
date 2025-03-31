package com.cinema.booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static com.cinema.booking.properties.Urls.HOME_PAGE;
import static com.cinema.booking.properties.Urls.LANDING_PAGE;
import static com.cinema.booking.properties.Urls.LOGIN;
import static com.cinema.booking.properties.Urls.LOG_OUT;
import static com.cinema.booking.properties.Urls.REGISTER;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers(HOME_PAGE, REGISTER).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage(LOGIN).permitAll()
                .defaultSuccessUrl(LANDING_PAGE) //Handles POST REQUEST
            )
            .logout(logout -> logout
                .logoutUrl(LOG_OUT)
                .logoutSuccessUrl(HOME_PAGE)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll() //Allows all users to access particular endpoint without any restrictions
            );

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//            User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}