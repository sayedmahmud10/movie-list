package com.example.movielisting.service;

import  com.example.movielisting.model.User;
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


}
