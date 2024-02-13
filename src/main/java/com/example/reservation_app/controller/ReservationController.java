package com.example.reservation_app.controller;

import com.example.reservation_app.model.Atelier;
import com.example.reservation_app.model.Participant;
import com.example.reservation_app.model.Reservation;
import com.example.reservation_app.service.AtelierService;
import com.example.reservation_app.service.ParticipantService;
import com.example.reservation_app.service.ReservationService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    // Services nécessaires au contrôleur
    private final ReservationService reservationService;
    private final AtelierService atelierService;
    private final ParticipantService participantService;

    // Injection des services via le constructeur
    @Autowired
    public ReservationController(ReservationService reservationService, AtelierService atelierService, ParticipantService participantService) {
        this.reservationService = reservationService;
        this.atelierService = atelierService;
        this.participantService = participantService;
    }

    // Gère les requêtes GET vers "/reservations"
    @GetMapping("/reservations")
    public String listReservations(Model model) {
        // Ajoute la liste des réservations au modèle pour l'affichage dans la vue Thymeleaf
        model.addAttribute("reservations", reservationService.getAllReservations());
        
        // Renvoie le nom du template Thymeleaf à afficher
        return "reservations";
    }
    
    // Gère les requêtes GET vers "/formulaireReservation"
    @GetMapping("/formulaireReservation")
    public String afficherFormulaireReservation(Model model) {
        // Récupère la liste des ateliers et des participants pour le formulaire de réservation
        List<Atelier> ateliers = atelierService.getAllAteliers();
        List<Participant> participants = participantService.getAllParticipants();
        
        // Ajoute les listes au modèle pour l'affichage dans la vue Thymeleaf
        model.addAttribute("ateliers", ateliers);
        model.addAttribute("participants", participants);
        
        // Renvoie le nom du template Thymeleaf à afficher
        return "formulaireReservation";
    }
    
    // Gère les requêtes POST vers "/reservations"
    @PostMapping("/reservations")
    public String reserverCreneau(@RequestParam("atelierId") Long id, @RequestParam("participantId") Long participantId, Model model) {
        try {
            // Tente de réserver un créneau avec les paramètres fournis
            Reservation nouvelleReservation = reservationService.reserverCreneau(id, participantId);
            
            // Ajoute un message de confirmation au modèle
            model.addAttribute("confirmationMessage", "Réservation réussie avec l'ID : " + nouvelleReservation.getId());
        } catch (EntityNotFoundException e) {
            // En cas d'erreur, ajoute un message d'erreur au modèle
            model.addAttribute("reservationErreur", "Erreur lors de la réservation : " + e.getMessage());
        }
        
        // Redirige vers la liste des réservations
        return "redirect:/reservations";
    }
    
    // Gère les requêtes GET vers "/reservations/{reservationId}"
    @GetMapping("/reservations/{reservationId}")
    public String annulerReservation(@PathVariable Long reservationId, Model model) {
        try {
            // Tente d'annuler une réservation avec l'ID spécifié
            reservationService.deleteReservation(reservationId);
            
            // Ajoute un message d'annulation réussie au modèle
            model.addAttribute("annulationMessage", "Réservation annulée avec succès");
        } catch (EntityNotFoundException e) {
            // En cas d'erreur, ajoute un message d'erreur d'annulation au modèle
            model.addAttribute("annulationErreur", "Erreur lors de l'annulation de la réservation : " + e.getMessage());
        }
        
        // Ajoute la liste mise à jour des réservations au modèle
        model.addAttribute("reservations", reservationService.getAllReservations());
        
        // Renvoie le nom du template Thymeleaf à afficher
        return "reservations";
    }
}
