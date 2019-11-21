package com.cesi.projetJavaSpringBoot.repositories;

import com.cesi.projetJavaSpringBoot.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
}
