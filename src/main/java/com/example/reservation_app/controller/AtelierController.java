package com.example.reservation_app.controller;

import com.example.reservation_app.service.AtelierService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AtelierController {

    private AtelierService atelierService;

    // Injection du service AtelierService via le constructeur
    @Autowired
    public AtelierController(AtelierService atelierService) {
        this.atelierService = atelierService;
    }

    // Gère les requêtes GET vers "/ateliers"
    @GetMapping("/ateliers")
    public String listAteliers(Model model) {
        // Ajoute la liste des ateliers au modèle pour être utilisée dans la vue
        model.addAttribute("ateliers", atelierService.getAllAteliers());
        // Renvoie le nom du template Thymeleaf à afficher
        return "ateliers";
    }

    // Méthode de modèle pour formater la date et l'heure
    @ModelAttribute("formattedDateTime")
    public String formattedDateTime(LocalDateTime dateTime) {
        if (dateTime != null) {
            // Formatte la date et l'heure selon le motif spécifié
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return dateTime.format(formatter);
        } else {
            // Si la date et l'heure sont nulles, renvoie un message par défaut
            return "Date et heure non disponibles";
        }
    }

    // Ajoute d'autres méthodes pour les différentes actions de l'atelier
}
