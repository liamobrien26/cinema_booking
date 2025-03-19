package com.cinema.booking.repository;

import com.cinema.booking.model.UserPO;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPO> user = userRepository.findByUsername(username);
        return user.map(u ->
                            User.withDefaultPasswordEncoder()
                                .username(username)
                                .password(u.getPassword())
                                .roles("USER")
                                .build()
            )
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
