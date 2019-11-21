package com.cesi.projetJavaSpringBoot.repositories;

import com.cesi.projetJavaSpringBoot.entities.Reunions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReunionRepository extends JpaRepository<Reunions, Integer> {
}
