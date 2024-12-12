package com.ivanfranchin.moviesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoviesAppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/check-email")
    public String checkEmail() {
        return "check-email";
    }

    @GetMapping("/movies")
    public String movies() {
        return "movies";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }
}