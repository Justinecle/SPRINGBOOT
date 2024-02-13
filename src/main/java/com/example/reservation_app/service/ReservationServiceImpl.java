package com.example.reservation_app.service;

import com.example.reservation_app.model.Atelier;
import com.example.reservation_app.model.Participant;
import com.example.reservation_app.model.Reservation;
import com.example.reservation_app.repository.ReservationRepository;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final AtelierService atelierService;
    private final ParticipantService participantService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, AtelierService atelierService, ParticipantService participantService) {
        this.reservationRepository = reservationRepository;
        this.atelierService = atelierService;
        this.participantService = participantService;
    }
    
    // Enregistre une nouvelle réservation dans la base de données
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Récupère une réservation par son identifiant
    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Récupère la liste de toutes les réservations dans la base de données
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Met à jour les informations d'une réservation dans la base de données
    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Réserve un créneau pour un atelier avec un participant donné
    @Transactional
    @Override
    public Reservation reserverCreneau(Long atelierId, Long participantId) {
        try {
            // Récupérer l'atelier et le participant
            Optional<Atelier> optionalAtelier = atelierService.getAtelierById(atelierId);
            Optional<Participant> optionalParticipant = participantService.getParticipantById(participantId);

            // Vérifier si l'atelier et le participant existent
            Atelier atelier = optionalAtelier.orElseThrow(() -> new EntityNotFoundException("L'atelier n'existe pas."));
            Participant participant = optionalParticipant.orElseThrow(() -> new EntityNotFoundException("Le participant n'existe pas."));

            // Créer une nouvelle réservation
            Reservation nouvelleReservation = new Reservation();
            nouvelleReservation.setAtelier(atelier);
            nouvelleReservation.setParticipant(participant);
            
            // Définir la date de réservation sur le timestamp actuel
            nouvelleReservation.setDate_reservation(LocalDateTime.now());

            // Enregistrez la réservation dans la base de données
            return reservationRepository.save(nouvelleReservation);
        } catch (EntityNotFoundException e) {
            // Gérer l'exception, par exemple, renvoyer vers une page d'erreur
            throw e; 
        }
    }
    
    // Supprime une réservation de la base de données par son identifiant
    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
