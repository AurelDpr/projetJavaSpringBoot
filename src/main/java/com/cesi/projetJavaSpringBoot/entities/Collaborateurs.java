package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "collaborateur")
public class Collaborateurs {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String email;
    private String mdp;
    @ManyToOne(cascade = CascadeType.ALL)
    private Roles role;
//    @ManyToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy="participants")
//    private List<Reunions> reunions;
//    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="collaborateur")
//    private List<Taches> taches;

    public Collaborateurs() {
        super();
    }

    public Collaborateurs(String nom, String prenom, String dateNaissance, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.mdp = mdp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

//    public List<Reunions> getReunions() {
//        return reunions;
//    }
//
//    public void setReunions(List<Reunions> reunions) {
//        this.reunions = reunions;
//    }
//
//    public List<Taches> getTaches() {
//        return taches;
//    }
//
//    public void setTaches(List<Taches> taches) {
//        this.taches = taches;
//    }
}
