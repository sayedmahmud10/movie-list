package com.example.movielisting.service;

import  com.example.movielisting.service.MovieService;
import com.example.movielisting.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieService();
        // Adding sample movies for testing
        movieService.addMovie(new Movie("Inception", "Leonardo DiCaprio", "Sci-Fi", "2010", 160000000));
        movieService.addMovie(new Movie("The Dark Knight", "Christian Bale", "Action", "2008", 185000000));
        movieService.addMovie(new Movie("Interstellar", "Matthew McConaughey", "Sci-Fi", "2014", 165000000));
        movieService.addMovie(new Movie("Titanic", "Leonardo DiCaprio", "Romance", "1997", 200000000));
    }

    @Test
    void testSearchMoviesByTitle() {
        List<Movie> result = movieService.searchMovies("Inception");
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
    }

    @Test
    void testSearchMoviesByCast() {
        List<Movie> result = movieService.searchMovies("Leonardo DiCaprio");
        assertEquals(2, result.size()); // Inception and Titanic
    }

    @Test
    void testSearchMoviesByCategory() {
        List<Movie> result = movieService.searchMovies("Sci-Fi");
        assertEquals(2, result.size()); // Inception and Interstellar
    }

    @Test
    void testSearchMoviesWithNoMatches() {
        List<Movie> result = movieService.searchMovies("Nonexistent Movie");
        assertEquals(0, result.size());
    }

    @Test
    void testGetMovieDetailsFound() {
        Optional<Movie> result = movieService.getMovieDetails("Inception");
        assertTrue(result.isPresent());
        assertEquals("Inception", result.get().getTitle());
    }

    @Test
    void testGetMovieDetailsNotFound() {
        Optional<Movie> result = movieService.getMovieDetails("Nonexistent Movie");
        assertFalse(result.isPresent());
    }
}
