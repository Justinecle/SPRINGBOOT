package com.example.reservation_app.service;

import com.example.reservation_app.model.Participant;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reservation_app.repository.ParticipantRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    // Repository nécessaire pour accéder aux données de l'entité Participant
    private final ParticipantRepository participantRepository;

    // Injection du ParticipantRepository par le constructeur
    @Autowired
    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    // Enregistre un nouveau participant dans la base de données
    @Override
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    // Récupère un participant par son identifiant
    @Override
    public Optional<Participant> getParticipantById(Long id) {
        return participantRepository.findById(id);
    }

    // Récupère la liste de tous les participants dans la base de données
    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Met à jour les informations d'un participant dans la base de données
    @Override
    public Participant updateParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    // Supprime un participant de la base de données par son identifiant
    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
