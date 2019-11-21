package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String libelle;
//    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="role")
//    private List<Collaborateurs> collaborateurs;

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

//    public List<Collaborateurs> getCollaborateurs() {
//        return collaborateurs;
//    }
//
//    public void setCollaborateurs(List<Collaborateurs> collaborateurs) {
//        this.collaborateurs = collaborateurs;
//    }
}
