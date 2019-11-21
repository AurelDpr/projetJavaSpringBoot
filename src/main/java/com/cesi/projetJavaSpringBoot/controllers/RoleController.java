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
    @GetMapping(path="/all")
    public Iterable<Roles> getAllRoles() {
        // This returns a JSON or XML with the users
//        System.out.println("fdsfsd");
//        System.out.println(roleRepository.findAll());
        return roleRepository.findAll();
    }

    @ApiOperation(value = "Ajouter un role")
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody Roles addNewRole (@RequestParam String libelle) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Roles role = new Roles(libelle);
        roleRepository.save(role);
        return role;
    }
}
