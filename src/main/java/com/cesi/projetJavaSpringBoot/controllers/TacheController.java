package com.cesi.projetJavaSpringBoot.controllers;

        import com.cesi.projetJavaSpringBoot.entities.Roles;
        import com.cesi.projetJavaSpringBoot.entities.Taches;
        import com.cesi.projetJavaSpringBoot.repositories.RoleRepository;
        import com.cesi.projetJavaSpringBoot.repositories.TacheRepository;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;

@Api( description="API pour les opérations CRUD sur les tâches.")
@RestController
@RequestMapping(path="/tache")
public class TacheController {
    @Autowired
    private TacheRepository tacheRepository;

    @ApiOperation(value = "Récuperer toutes les tâches")
    @CrossOrigin
    @GetMapping(path="/read")
    public Iterable<Taches> getAllTaches() {
        return tacheRepository.findAll();
    }

    @ApiOperation(value = "Ajouter une tâche")
    @CrossOrigin
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody
    Taches addNewTache (
            @RequestParam String libelle,
            @RequestParam String description,
            @RequestParam String dateDebut,
            @RequestParam String dateFin,
            @RequestParam int duree
    ) {
            Taches tache = new Taches(libelle,description,dateDebut,dateFin,duree);
            tacheRepository.save(tache);
            return tache;
    }

    @ApiOperation(value = "Supprimer une tâche")
    @CrossOrigin
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteTache (@RequestParam Long tacheId) {
        tacheRepository.deleteById(tacheId);
        return "suppression";
    }

    @ApiOperation(value = "Modifier une tâche")
    @CrossOrigin
    @PatchMapping(path="/update")
    public @ResponseBody String updateTache (
            @RequestParam Long id,
            @RequestParam String libelle,
            @RequestParam String description,
            @RequestParam String dateDebut,
            @RequestParam String dateFin,
            @RequestParam int duree
    ) {
        Taches tacheFromDb = tacheRepository.findById(id).get();
        tacheFromDb.setLibelle(libelle);
        tacheFromDb.setDescription(description);
        tacheFromDb.setDateDebut(dateDebut);
        tacheFromDb.setDateFin(dateFin);
        tacheFromDb.setDuree(duree);
        tacheRepository.save(tacheFromDb);
        return "update";
    }

}
