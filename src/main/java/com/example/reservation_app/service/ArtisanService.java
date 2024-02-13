package com.example.reservation_app.service;

import com.example.reservation_app.model.Artisan;
import java.util.List;
import java.util.Optional;

public interface ArtisanService {
    // L'interface ArtisanService définit les opérations de base à effectuer sur les entités Artisan.

    // Méthode pour sauvegarder un nouvel artisan
    Artisan saveArtisan(Artisan artisan);

    // Méthode pour récupérer un artisan par son ID
    Optional<Artisan> getArtisanById(Long id);

    // Méthode pour récupérer tous les artisans
    List<Artisan> getAllArtisans();

    // Méthode pour mettre à jour les informations d'un artisan
    Artisan updateArtisan(Artisan artisan);

    // Méthode pour supprimer un artisan par son ID
    void deleteArtisan(Long id);
}
