package com.cinema.booking.controller;

import com.cinema.booking.model.Movie;
import com.cinema.booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable String id, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie.orElse(null));
        return "movie";
    }

    @GetMapping("/new")
    public String createMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "create_movie";
    }

    @PostMapping
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
