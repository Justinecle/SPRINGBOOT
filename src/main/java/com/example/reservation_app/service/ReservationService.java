package com.example.reservation_app.service;

import com.example.reservation_app.model.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    // Enregistre une nouvelle réservation dans la base de données
    Reservation saveReservation(Reservation reservation);

    // Récupère une réservation par son identifiant
    Optional<Reservation> getReservationById(Long id);

    // Récupère la liste de toutes les réservations dans la base de données
    List<Reservation> getAllReservations();

    // Met à jour les informations d'une réservation dans la base de données
    Reservation updateReservation(Reservation reservation);

    // Supprime une réservation de la base de données par son identifiant
    void deleteReservation(Long id);

    // Réserve un créneau pour un atelier avec un participant donné
    Reservation reserverCreneau(Long atelierId, Long participantId);
}
