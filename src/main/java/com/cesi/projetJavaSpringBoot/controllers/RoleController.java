package com.cesi.projetJavaSpringBoot.controllers;

import com.cesi.projetJavaSpringBoot.entities.Roles;
import com.cesi.projetJavaSpringBoot.repositories.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api( description="API pour les opérations CRUD sur les rôles.")
@RestController
@RequestMapping(path="/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @ApiOperation(value = "Récuperer tout les rôles")
    @CrossOrigin
    @GetMapping(path="/read")
    public Iterable<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @ApiOperation(value = "Ajouter un rôle")
    @CrossOrigin
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody Roles addNewRole (@RequestParam String libelle) {
        Roles role = new Roles(libelle);
        roleRepository.save(role);
        return role;
    }

    @ApiOperation(value = "Supprimer un rôle")
    @CrossOrigin
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteRole (@RequestParam Long roleId) {
        roleRepository.deleteById(roleId);
        return "suppression";
    }

    @ApiOperation(value = "Modifier un rôle")
    @CrossOrigin
    @PatchMapping(path="/update")
    public @ResponseBody String updateRole (@RequestParam Long id, @RequestParam String libelle) {
        Roles roleFromDb = roleRepository.findById(id).get();
        roleFromDb.setLibelle(libelle);
        roleRepository.save(roleFromDb);
        return "update";
    }


}
