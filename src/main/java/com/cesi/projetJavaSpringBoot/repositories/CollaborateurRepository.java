package com.cesi.projetJavaSpringBoot.repositories;

import com.cesi.projetJavaSpringBoot.entities.Collaborateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborateurRepository extends JpaRepository<Collaborateurs, Integer> {
}
