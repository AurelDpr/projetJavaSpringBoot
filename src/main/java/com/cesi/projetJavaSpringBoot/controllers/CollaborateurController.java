package com.cesi.projetJavaSpringBoot.controllers;

import com.cesi.projetJavaSpringBoot.entities.Collaborateurs;
import com.cesi.projetJavaSpringBoot.repositories.CollaborateurRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api( description="API pour les opérations CRUD sur les collaborateurs.")
@RestController
@RequestMapping(path="/collaborateur")
public class CollaborateurController {

    @Autowired
    private CollaborateurRepository collaborateurRepository;

    @ApiOperation(value = "Récupere tout les collaborateurs")
    @GetMapping(path="/read")
    public Iterable<Collaborateurs> getAllCollaborateurs() {
        return collaborateurRepository.findAll();
    }

    @ApiOperation(value = "Ajouter un collaborateur")
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody
    Collaborateurs addNewCollaborateur (@RequestParam String nom, @RequestParam String prenom, @RequestParam String dateNaissance, @RequestParam String mdp, @RequestParam String email) {
        Collaborateurs collaborateur = new Collaborateurs(nom, prenom, dateNaissance, mdp, email);
        collaborateurRepository.save(collaborateur);
        return collaborateur;
    }

    @ApiOperation(value = "Supprimer un collaborateur")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteCollaborateur (@RequestParam Long collaborateurId) {
        collaborateurRepository.deleteById(collaborateurId);
        return "suppression";
    }
}
