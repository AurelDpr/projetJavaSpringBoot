package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String libelle;

    public Roles() {
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
}
