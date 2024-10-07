package com.movielisting.service;

import  com.example.movielisting.service.UserService;
import  com.example.movielisting.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private List<User> users;
    private Movie movie1;
    private Movie movie2;
    private User  user1;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        users = new ArrayList<>();
        movie1 = new Movie("Inception", "Leonardo DiCaprio", "Sci-Fi", "2010", 160000000);
        movie2 = new Movie("Titanic", "Leonardo DiCaprio", "Romance", "1997", 200000000);
        user1 = new User("test@example.com");

    }

    @Test
    void testRegisterUser() {
        String email = "test@example.com";
        User user = userService.registerUser(email);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testLoginExistingUser() {
        String email = "test@example.com";
        User user = userService.registerUser(email);
        users.add(user);
        Optional<User> loggedInUser = userService.login(users, email);
        assertTrue(loggedInUser.isPresent());
        assertEquals(email, loggedInUser.get().getEmail());
    }

    @Test
    void testAddFavoriteMovie() {
        userService.addFavoriteMovie(user1, movie1);
        assertTrue(user1.getFavoriteMovies().contains(movie1));
    }

    @Test
    void testRemoveFavoriteMovie() {
        userService.addFavoriteMovie(user1, movie1);
        userService.removeFavoriteMovie(user1, movie1);
        assertFalse(user1.getFavoriteMovies().contains(movie1));
    }

    @Test
    void testShowUserDetails() {
        userService.addFavoriteMovie(user1, movie1);
        userService.addFavoriteMovie(user1, movie2);
        userService.showUserDetails(user1);
        assertEquals(2, user1.getFavoriteMovies().size());
        assertTrue(user1.getFavoriteMovies().contains(movie1));
        assertTrue(user1.getFavoriteMovies().contains(movie2));
    }
    @Test
    void testSearchFavoriteMovies() {
        userService.addFavoriteMovie(user1, movie1);
        userService.addFavoriteMovie(user1, movie2);
        List<Movie> searchResult = userService.searchFavoriteMovies(user1, "Titanic");
        assertEquals(1, searchResult.size());
        assertEquals("Titanic", searchResult.get(0).getTitle());
        searchResult = userService.searchFavoriteMovies(user1, "Leonardo");
        assertEquals(2, searchResult.size());
    }


}
