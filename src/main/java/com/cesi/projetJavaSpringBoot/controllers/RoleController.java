package com.cesi.projetJavaSpringBoot.controllers;

import com.cesi.projetJavaSpringBoot.entities.Roles;
import com.cesi.projetJavaSpringBoot.repositories.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api( description="API pour les opérations CRUD sur les roles.")
@RestController
@RequestMapping(path="/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @ApiOperation(value = "Récupere tout les roles")
    @GetMapping(path="/read")
    public Iterable<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @ApiOperation(value = "Ajouter un role")
    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody Roles addNewRole (@RequestParam String libelle) {
        Roles role = new Roles(libelle);
        roleRepository.save(role);
        return role;
    }

    @ApiOperation(value = "Supprimer un role")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteRole (@RequestParam Long roleId) {
        roleRepository.deleteById(roleId);
        return "suppression";
    }
}
