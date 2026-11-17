package com.example.ms1.service;

import com.example.ms1.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>(List.of(
            new User(1L, "Alice", "alice@example.com"),
            new User(2L, "Bob", "bob@example.com")
    ));

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }
}
