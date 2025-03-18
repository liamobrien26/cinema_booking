package com.cinema.booking.controller;

import com.cinema.booking.model.Movie;
import com.cinema.booking.repository.MovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import static com.cinema.booking.properties.Urls.ADD_MOVIE;
import static com.cinema.booking.properties.Urls.GET_ALL_MOVIES;
import static com.cinema.booking.properties.Urls.REMOVE_MOVIE;


@RestController //@RestController tells Maven that the following class is a controller for a web application.
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    @PostMapping(ADD_MOVIE)
    public String addMovie(@RequestParam String movieId,
                           @RequestParam String movieTitle,
                           @RequestParam String movieDescription,
                           @RequestParam Float movieRating,
                           @RequestParam Integer movieReleaseDate,
                           @RequestParam String movieGenre,
                           @RequestParam Integer movieYear,
                           @RequestParam String movieDirector) {
        Movie movie = new Movie();
        movie.setMovieId(movieId);
        movie.setMovieTitle(movieTitle);
        movie.setMovieDescription(movieDescription);
        movie.setMovieRating(movieRating);
        movie.setMovieReleaseDate(movieReleaseDate);
        movie.setMovieGenre(movieGenre);
        movie.setMovieYear(movieYear);
        movie.setMovieDirector(movieDirector);
        movieRepository.save(movie);
        return ADD_MOVIE;
    }

    @PostMapping(REMOVE_MOVIE)
    public String removeMovie(){
        return REMOVE_MOVIE;
    }

    @GetMapping(GET_ALL_MOVIES)
    public String getAllMovies() {
        return GET_ALL_MOVIES;
    }
}
