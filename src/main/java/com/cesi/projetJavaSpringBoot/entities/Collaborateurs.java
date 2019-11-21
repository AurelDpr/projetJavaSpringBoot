package com.cesi.projetJavaSpringBoot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "collaborateur")
public class Collaborateurs {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String mdp;
    @ManyToOne(cascade = CascadeType.ALL)
    private Roles role;
    @ManyToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy="participants")
    private List<Reunions> reunions;
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="collaborateur")
    private List<Taches> taches;

    public Collaborateurs() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
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
}
