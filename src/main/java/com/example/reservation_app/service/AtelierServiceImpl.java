package com.example.reservation_app.service;

import com.example.reservation_app.model.Atelier;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reservation_app.repository.AtelierRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtelierServiceImpl implements AtelierService {

    // Repository pour accéder aux données des ateliers
    private final AtelierRepository atelierRepository;

    // Injection de dépendances via le constructeur
    @Autowired
    public AtelierServiceImpl(AtelierRepository atelierRepository) {
        this.atelierRepository = atelierRepository;
    }

    // Enregistre un atelier dans la base de données.
    @Override
    public Atelier saveAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    // Récupère un atelier par son identifiant.
    @Override
    public Optional<Atelier> getAtelierById(Long id) {
        return atelierRepository.findById(id);
    }

    // Récupère tous les ateliers de la base de données.
    @Override
    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }

    // Met à jour les informations d'un atelier dans la base de données.
    @Override
    public Atelier updateAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    // Supprime un atelier de la base de données par son identifiant.
    @Override
    public void deleteAtelier(Long id) {
        atelierRepository.deleteById(id);
    }
}
