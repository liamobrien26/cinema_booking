package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Setter;

@Document(collection = "movie")
@Setter
public class Movie {

    private String movieId;
    private String movieTitle;
    private String movieDescription;
    private Float movieRating;
    private String movieReleaseDate;
    private String movieGenre;
    private Integer movieYear;
    private String movieDirector;
}
