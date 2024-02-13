package com.example.reservation_app.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "artisans")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artisan")
    private Long id;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "mot_de_passe", nullable = false, length = 255)
    private String mot_de_passe;
    
    @Column(name = "date_inscription")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_inscription;

    @OneToMany(mappedBy = "artisan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Atelier> ateliers;

    // Getters et Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public List<Atelier> getAteliers() {
		return ateliers;
	}

	public void setAteliers(List<Atelier> ateliers) {
		this.ateliers = ateliers;
	}
}
