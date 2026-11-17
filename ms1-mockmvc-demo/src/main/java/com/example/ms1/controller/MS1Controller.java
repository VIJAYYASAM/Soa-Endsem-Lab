package com.example.ms1.controller;

import com.example.ms1.model.User;
import com.example.ms1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms1")
public class MS1Controller {

    private final UserService userService;

    public MS1Controller(UserService userService) {
        this.userService = userService;
    }

    // Arithmetic Operations
    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam("a") int a, @RequestParam("b") int b) {
        int sum = a + b;
        // Exact string matching Step 3 requirement: "MS 1.1 - Additon = 15"
        return ResponseEntity.ok("MS 1.1 - Additon = " + sum);
    }

    @GetMapping("/subtract")
    public ResponseEntity<String> subtract(@RequestParam("a") int a, @RequestParam("b") int b) {
        int diff = a - b;
        return ResponseEntity.ok("MS 1.1 - Subtraction = " + diff);
    }

    // User Management Endpoints
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
