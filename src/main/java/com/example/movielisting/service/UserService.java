package com.example.movielisting.service;

import  com.example.movielisting.model.*;
import java.util.List;
import java.util.Optional;

public class UserService {

    public User registerUser(String email) {
        return new User(email);
    }

    public Optional<User> login(List<User> users, String email) {
        return users.stream()
                    .filter(user -> user.getEmail().equals(email))
                    .findFirst();
    }

      public void addFavoriteMovie(User user, Movie movie) {
            user.getFavoriteMovies().add(movie);
        }

        public void removeFavoriteMovie(User user, Movie movie) {
            user.getFavoriteMovies().remove(movie);
        }

       public void showUserDetails(User user) {
            System.out.println("User Email: " + user.getEmail());
            System.out.println("Favorite Movies:");
            if (user.getFavoriteMovies().isEmpty()) {
                System.out.println("No favorite movies added.");
            } else {
                user.getFavoriteMovies().forEach(movie -> System.out.println(movie.getTitle()));
            }
        }

        public List<Movie> searchFavoriteMovies(User user, String query) {
            return user.getFavoriteMovies().stream()
                    .filter(movie -> movie.getTitle().toLowerCase().contains(query.toLowerCase())
                            || movie.getCast().toLowerCase().contains(query.toLowerCase())
                            || movie.getCategory().toLowerCase().contains(query.toLowerCase()))
                    .toList();
        }


}
