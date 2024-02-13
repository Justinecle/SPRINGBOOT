package com.example.reservation_app.repository;

import com.example.reservation_app.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    // La classe ParticipantRepository étend JpaRepository pour bénéficier des fonctionnalités CRUD de JPA.

    // Aucune méthode spécifique n'est ajoutée ici, car JpaRepository fournit déjà des méthodes pour les opérations de base.
    // Si des requêtes personnalisées sont nécessaires, elles peuvent être définies ici.
}
