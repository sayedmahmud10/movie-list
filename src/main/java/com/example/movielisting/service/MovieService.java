package com.example.movielisting.service;

import  com.example.movielisting.model.Movie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class MovieService {
    private List<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Method to search movies by title, cast, or category
    public List<Movie> searchMovies(String query) {
        return movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(query.toLowerCase())
                        || movie.getCast().toLowerCase().contains(query.toLowerCase())
                        || movie.getCategory().toLowerCase().contains(query.toLowerCase()))
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());
    }

 public Optional<Movie> getMovieDetails(String title) {
     return movies.stream()
             .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
             .findFirst();
 }
}
