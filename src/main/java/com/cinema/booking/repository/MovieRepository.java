package com.cinema.booking.repository;

import com.cinema.booking.model.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie,String> {

}
