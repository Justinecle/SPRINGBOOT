package com.example.reservation_app.service;

import com.example.reservation_app.model.Atelier;
import java.util.List;
import java.util.Optional;

public interface AtelierService {
    // Enregistre un atelier dans la base de données.
    Atelier saveAtelier(Atelier atelier);

    // Récupère un atelier par son identifiant.
    Optional<Atelier> getAtelierById(Long id);

    // Récupère tous les ateliers de la base de données.
    List<Atelier> getAllAteliers();

    // Met à jour les informations d'un atelier dans la base de données.
    Atelier updateAtelier(Atelier atelier);

    // Supprime un atelier de la base de données par son identifiant.
    void deleteAtelier(Long id);
}
