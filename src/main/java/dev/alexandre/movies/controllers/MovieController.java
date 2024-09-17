package dev.alexandre.movies.controllers;

import dev.alexandre.movies.services.MovieService;
import dev.alexandre.movies.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId), HttpStatus.OK);
    }
}
