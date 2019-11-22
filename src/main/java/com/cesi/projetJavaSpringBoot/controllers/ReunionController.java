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
    public Iterable<Reunions> getAllReunions() {
        return reunionRepository.findAll();
    }

    @ApiOperation(value = "Ajouter une réunion")
    @CrossOrigin
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody
    Reunions addNewReunion (
            @RequestBody Reunions pReunion
    ) {
        Reunions reunion = new Reunions(
                pReunion.getLibelle(),
                pReunion.getObjectif(),
                pReunion.getDate(),
                pReunion.getCompteRendu(),
                pReunion.getLieu(),
                pReunion.getParticipants(),
                pReunion.getReferant(),
                pReunion.getTaches());
        reunionRepository.save(reunion);
        return reunion;
    }

    @ApiOperation(value = "Supprimer une réunion")
    @CrossOrigin
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteReunion (@RequestParam Long reunionId) {
        reunionRepository.deleteById(reunionId);
        return "suppression";
    }
}
