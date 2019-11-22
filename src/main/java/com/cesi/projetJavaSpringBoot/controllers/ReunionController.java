package com.cesi.projetJavaSpringBoot.controllers;

import com.cesi.projetJavaSpringBoot.entities.Reunions;
import com.cesi.projetJavaSpringBoot.repositories.ReunionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api( description="API pour les opérations CRUD sur les réunions.")
@RestController
@RequestMapping(path="/reunion")
public class ReunionController {

    @Autowired
    private ReunionRepository reunionRepository;

    @ApiOperation(value = "Récuperer toutes les réunions")
    @CrossOrigin
    @GetMapping(path="/read")
    public Iterable<Reunions> getAllCollaborateurs() {
        return reunionRepository.findAll();
    }

    @ApiOperation(value = "Ajouter une réunion")
    @CrossOrigin
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody
    Reunions addNewReunion (
            @RequestParam String libelle,
            @RequestParam String objectif,
            @RequestParam String date,
            @RequestParam String lieu,
            @RequestParam String compteRendu
    ) {
        Reunions collaborateur = new Reunions(libelle, objectif, date, lieu, compteRendu);
        reunionRepository.save(collaborateur);
        return collaborateur;
    }

    @ApiOperation(value = "Supprimer une réunion")
    @CrossOrigin
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteReunion (@RequestParam Long reunionId) {
        reunionRepository.deleteById(reunionId);
        return "suppression";
    }
}
