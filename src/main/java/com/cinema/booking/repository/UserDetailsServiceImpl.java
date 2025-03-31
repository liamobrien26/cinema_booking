package com.cinema.booking.repository;

import com.cinema.booking.model.UserPO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

// Handles user authentication
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;  // Repository to fetch user data from database

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPO> user = userRepository.findByUsername(username);

        return user.map(u ->
                User.withUsername(username)
                        .password(u.getPassword())  // The password is already hashed in the database
                        .roles("USER")  // Assigns user role
                        .build()
        ).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
