package com.cinema.booking.controller;

import com.cinema.booking.model.Movie;
import com.cinema.booking.repository.MovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

import static com.cinema.booking.properties.Urls.ADD_MOVIE;
import static com.cinema.booking.properties.Urls.VIEW_MOVIE;
import static com.cinema.booking.properties.Urls.REMOVE_MOVIE;


@RestController //@RestController tells Maven that the following class is a controller for a web application.
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    private static final String ADD_MOVIE_VIEW_NAME = "add-movie-page";
    private static final String VIEW_MOVIE_VIEW_NAME = "view-movie-page";

    private static final String VIEW_MOVIE_MODEL_NAME = "movies"; //Get object from database

    @GetMapping(VIEW_MOVIE)
    public ModelAndView getViewMovies() {
        return new ModelAndView(VIEW_MOVIE_VIEW_NAME,
                                VIEW_MOVIE_MODEL_NAME,
                                movieRepository.findAll());
    }

    @GetMapping(ADD_MOVIE)
    public ModelAndView getAddMoviePage() {
        return new ModelAndView(ADD_MOVIE_VIEW_NAME);
    }

    @PostMapping(ADD_MOVIE)
    public ModelAndView addMovie(
                           @RequestParam String movieTitle,
                           @RequestParam String movieDescription,
                           @RequestParam Float movieRating,
                           @RequestParam String movieReleaseDate,
                           @RequestParam String movieGenre,
                           @RequestParam Integer movieYear,
                           @RequestParam String movieDirector
    ) {
        Movie movie = new Movie();
        movie.setMovieId(UUID.randomUUID().toString());
        movie.setMovieTitle(movieTitle);
        movie.setMovieDescription(movieDescription);
        movie.setMovieRating(movieRating);
        movie.setMovieReleaseDate(movieReleaseDate);
        movie.setMovieGenre(movieGenre);
        movie.setMovieYear(movieYear);
        movie.setMovieDirector(movieDirector);
        movieRepository.save(movie);
        return new ModelAndView(ADD_MOVIE_VIEW_NAME);
    }

    @PostMapping(REMOVE_MOVIE)
    public String removeMovie(){
        return REMOVE_MOVIE;
    }
}
