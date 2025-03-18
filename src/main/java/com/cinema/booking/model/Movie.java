package com.cinema.booking.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {

    private String movieId;
    private String movieTitle;
    private String movieDescription;
    private Float movieRating;
    private Integer movieReleaseDate;
    private String movieGenre;
    private Integer movieYear;
    private String movieDirector;

    public void setMovieId(String movieId) {this.movieId = movieId;}
    public void setMovieTitle(String movieTitle) {this.movieTitle = movieTitle;}
    public void setMovieDescription(String movieDescription) {this.movieDescription = movieDescription;}
    public void setMovieRating(Float movieRating) {this.movieRating = movieRating;}
    public void setMovieReleaseDate(Integer movieReleaseDate) {this.movieReleaseDate = movieReleaseDate;}
    public void setMovieGenre(String movieGenre) {this.movieGenre = movieGenre;}
    public void setMovieYear(Integer movieYear) {this.movieYear = movieYear;}
    public void setMovieDirector(String movieDirector) {this.movieDirector = movieDirector;}
}
