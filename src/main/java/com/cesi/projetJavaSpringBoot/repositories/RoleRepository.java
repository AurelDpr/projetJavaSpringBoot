package com.cesi.projetJavaSpringBoot.repositories;

import com.cesi.projetJavaSpringBoot.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
