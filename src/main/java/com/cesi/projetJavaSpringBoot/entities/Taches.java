package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tache")
public class Taches {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String libelle;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private int duree;
    @ManyToOne(cascade = CascadeType.ALL)
    private Collaborateurs collaborateur;
    @ManyToOne(cascade = CascadeType.ALL)
    private Reunions reunion;

    public Taches() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
