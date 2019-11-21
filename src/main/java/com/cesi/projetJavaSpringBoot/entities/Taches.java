package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tache")
public class Taches {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String description;
    private String dateDebut;
    private String dateFin;
    private int duree;
    @ManyToOne(cascade = CascadeType.ALL)
    private Collaborateurs collaborateur;
    @ManyToOne(cascade = CascadeType.ALL)
    private Reunions reunion;

    public Taches() {
    }

    public Taches(String libelle, String description, String dateDebut, String dateFin, int duree, Collaborateurs collaborateur, Reunions reunion) {
        this.libelle = libelle;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.duree = duree;
        this.collaborateur = collaborateur;
        this.reunion = reunion;
    }

    public Taches(String libelle, String description, String dateDebut, String dateFin, int duree) {
        this.libelle = libelle;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.duree = duree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Collaborateurs getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateurs collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Reunions getReunion() {
        return reunion;
    }

    public void setReunion(Reunions reunion) {
        this.reunion = reunion;
    }
}
