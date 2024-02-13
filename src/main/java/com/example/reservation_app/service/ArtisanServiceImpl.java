package com.example.reservation_app.service;

import com.example.reservation_app.model.Artisan;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reservation_app.repository.ArtisanRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArtisanServiceImpl implements ArtisanService {

    private final ArtisanRepository artisanRepository;

    @Autowired
    public ArtisanServiceImpl(ArtisanRepository artisanRepository) {
        this.artisanRepository = artisanRepository;
    }

    /**
     * Enregistre un artisan dans la base de données.
     *
     * @param artisan L'artisan à enregistrer.
     * @return L'artisan enregistré.
     */
    @Override
    public Artisan saveArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    /**
     * Récupère un artisan par son identifiant.
     *
     * @param id L'identifiant de l'artisan à récupérer.
     * @return L'artisan correspondant à l'identifiant, s'il existe.
     */
    @Override
    public Optional<Artisan> getArtisanById(Long id) {
        return artisanRepository.findById(id);
    }

    /**
     * Récupère tous les artisans de la base de données.
     *
     * @return La liste de tous les artisans.
     */
    @Override
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    /**
     * Met à jour les informations d'un artisan dans la base de données.
     *
     * @param artisan L'artisan à mettre à jour.
     * @return L'artisan mis à jour.
     */
    @Override
    public Artisan updateArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    /**
     * Supprime un artisan de la base de données par son identifiant.
     *
     * @param id L'identifiant de l'artisan à supprimer.
     */
    @Override
    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }
}
