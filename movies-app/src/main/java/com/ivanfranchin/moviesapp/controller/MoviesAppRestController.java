package com.ivanfranchin.moviesapp.controller;

import com.ivanfranchin.moviesapp.user.User;
import com.ivanfranchin.moviesapp.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MoviesAppRestController {

    private final UserService userService;

    public MoviesAppRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    private User getUser(@PathVariable String username) {
        return userService.validateAndGetByUsername(username);
    }

    @GetMapping
    private List<User> getUsers() {
        return userService.getUsers();
    }
}
