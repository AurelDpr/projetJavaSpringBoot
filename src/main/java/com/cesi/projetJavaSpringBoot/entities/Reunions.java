package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reunion")
public class Reunions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String objectif;
    private String date;
    private String lieu;
    private String compteRendu;
    @ManyToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL)
    private List<Collaborateurs> participants;
    @ManyToOne(cascade = CascadeType.ALL)
    private Collaborateurs referant;
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="reunion")
    private List<Taches> taches;

    public Reunions() {
    }

    public Reunions(String libelle, String objectif, String date, String lieu, String compteRendu) {
        this.libelle = libelle;
        this.objectif = objectif;
        this.date = date;
        this.lieu = lieu;
        this.compteRendu = compteRendu;
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

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }
}
