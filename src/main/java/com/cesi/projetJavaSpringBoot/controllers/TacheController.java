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

@Api( description="API pour les opérations CRUD sur les roles.")
@RestController
@RequestMapping(path="/taches")
public class TacheController {
    @Autowired
    private TacheRepository tacheRepository;

    @ApiOperation(value = "Récupere toutes les tâches")
    @GetMapping(path="/read")
    public Iterable<Taches> getAllTaches() {
        return tacheRepository.findAll();
    }

    @ApiOperation(value = "Ajouter une tache")
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody
    Taches addNewTache (@RequestParam String libelle, @RequestParam String description, @RequestParam String dateDebut, @RequestParam String dateFin, @RequestParam int duree) {
            Taches tache = new Taches(libelle,description,dateDebut,dateFin,duree);
            tacheRepository.save(tache);
            return tache;
    }

//    @ApiOperation(value = "Supprimer un role")
//    @DeleteMapping(path="/delete")
//    public @ResponseBody String deleteRole (@RequestParam int roleId) {
//        roleRepository.delete(roleRepository.findById(roleId));
//        return "suppression";
//    }

}
