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

    @ApiOperation(value = "Récuperer tout les collaborateurs")
    @CrossOrigin
    @GetMapping(path="/read")
    public Iterable<Collaborateurs> getAllCollaborateurs() {
        return collaborateurRepository.findAll();
    }

    @ApiOperation(value = "Ajouter un collaborateur")
    @CrossOrigin
    @PostMapping(path="/create")
    public @ResponseBody
    Collaborateurs addNewCollaborateur (@RequestBody Collaborateurs pCollaborateur) {
        System.out.println('t');
        Collaborateurs collaborateur = new Collaborateurs(
                pCollaborateur.getNom(),
                pCollaborateur.getPrenom(),
                pCollaborateur.getDateNaissance(),
                pCollaborateur.getMdp(),
                pCollaborateur.getEmail(),
                pCollaborateur.getRole()
        );
        collaborateurRepository.save(collaborateur);
        return collaborateur;
    }

    @ApiOperation(value = "Supprimer un collaborateur")
    @CrossOrigin
    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteCollaborateur (@PathVariable Long id) {
        collaborateurRepository.deleteById(id);
        return "suppression";
    }

    @ApiOperation(value = "Modifier un collaborateur")
    @CrossOrigin
    @PatchMapping(path="/update")
    public @ResponseBody String updateCollaborateur (
            @RequestParam Long id,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String dateNaissance,
            @RequestParam String email,
            @RequestParam String mdp
    ) {
        Collaborateurs collaborateurFromDb = collaborateurRepository.findById(id).get();
        collaborateurFromDb.setNom(nom);
        collaborateurFromDb.setPrenom(prenom);
        collaborateurFromDb.setDateNaissance(dateNaissance);
        collaborateurFromDb.setEmail(email);
        collaborateurFromDb.setMdp(mdp);
        collaborateurRepository.save(collaborateurFromDb);
        return "update";
    }
}
