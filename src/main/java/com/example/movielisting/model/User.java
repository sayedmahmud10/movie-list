package com.example.movielisting.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Movie> favoriteMovies;

    // Constructor
    public User(String email) {
        this.email = email;
        this.favoriteMovies = new ArrayList<>();
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addFavoriteMovie(Movie movie) {
        if (!favoriteMovies.contains(movie)) {
            favoriteMovies.add(movie);
        }
    }

    public void removeFavoriteMovie(Movie movie) {
        favoriteMovies.remove(movie);
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", favoriteMovies=" + favoriteMovies +
                '}';
    }
}
