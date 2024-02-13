package com.example.reservation_app.controller;

import com.example.reservation_app.service.ArtisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtisanController {

    private final ArtisanService artisanService;

    // Injecte le service Artisan via le constructeur
    @Autowired
    public ArtisanController(ArtisanService artisanService) {
        this.artisanService = artisanService;
    }

    // Gère la requête GET sur "/artisans"
    @GetMapping("/artisans")
    public String listArtisans(Model model) {
        // Récupère la liste des artisans depuis le service
        model.addAttribute("artisans", artisanService.getAllArtisans());
        // Retourne le nom du template Thymeleaf à afficher (généralement le nom de la page HTML)
        return "artisans";
    }

    // Ajoute d'autres méthodes pour gérer différentes actions liées aux artisans
}
