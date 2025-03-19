package com.cinema.booking.repository;

import com.cinema.booking.model.UserPO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserPO, String> {
    Optional<UserPO> findByUsername(String userId);

}