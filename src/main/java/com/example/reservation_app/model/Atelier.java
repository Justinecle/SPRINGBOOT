package com.example.reservation_app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ateliers")
public class Atelier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atelier")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artisan")
    private Artisan artisan;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creneau")
    private LocalDateTime creneau;
    
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP) 
    private Date dateCreation;

    @OneToMany(mappedBy = "atelier", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Getters et Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreneau() {
		return creneau;
	}

	public void setCreneau(LocalDateTime creneau) {
		this.creneau = creneau;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
