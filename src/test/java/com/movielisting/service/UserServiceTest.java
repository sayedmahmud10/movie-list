package com.movielisting.service;

import  com.example.movielisting.service.UserService;
import  com.example.movielisting.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private List<User> users;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        users = new ArrayList<>();
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



}
