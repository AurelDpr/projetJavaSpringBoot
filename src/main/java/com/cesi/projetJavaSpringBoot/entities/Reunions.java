package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reunion")
public class Reunions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String libelle;
    private String objectif;
    private Date date;
    private String lieu;
    private String compteRendu;

    public Reunions() {
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

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
