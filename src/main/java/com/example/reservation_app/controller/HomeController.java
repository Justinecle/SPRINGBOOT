package com.example.reservation_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Gère les requêtes GET vers "/"
    @GetMapping("/")
    public String home() {
        // Renvoie le nom du template Thymeleaf à afficher
        return "index";
    }
}
