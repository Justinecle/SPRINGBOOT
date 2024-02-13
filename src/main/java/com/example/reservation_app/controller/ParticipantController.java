package com.example.reservation_app.controller;

import com.example.reservation_app.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParticipantController {
    
    // Service responsable de la logique métier des participants
    private final ParticipantService participantService;

    // Injection du service via le constructeur
    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    // Gère les requêtes GET vers "/participants"
    @GetMapping("/participants")
    public String listParticipants(Model model) {
        // Ajoute la liste des participants au modèle pour l'affichage dans la vue Thymeleaf
        model.addAttribute("participants", participantService.getAllParticipants());
        
        // Renvoie le nom du template Thymeleaf à afficher
        return "participants";
    }

    // Ajoute d'autres méthodes pour les différentes actions du participant
}
