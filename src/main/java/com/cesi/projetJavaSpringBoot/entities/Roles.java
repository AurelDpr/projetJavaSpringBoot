package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String libelle;
//    @OneToMany(mappedBy="role")
//    private Collection<Collaborateurs> collaborateurs;

    public Roles() {
    }

    public Roles(String libelle) {
        this.libelle = libelle;
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

//    public Collection<Collaborateurs> getCollaborateurs() {
//        return collaborateurs;
//    }
//
//    public void setCollaborateurs(Collection<Collaborateurs> collaborateurs) {
//        this.collaborateurs = collaborateurs;
//    }
}
