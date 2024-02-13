package com.example.reservation_app.service;

import com.example.reservation_app.model.Participant;
import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    // Enregistre un participant dans la base de données.
    Participant saveParticipant(Participant participant);

    // Récupère un participant par son identifiant.
    Optional<Participant> getParticipantById(Long id);

    // Récupère tous les participants de la base de données.
    List<Participant> getAllParticipants();

    // Met à jour les informations d'un participant dans la base de données.
    Participant updateParticipant(Participant participant);

    // Supprime un participant de la base de données par son identifiant.
    void deleteParticipant(Long id);
}
