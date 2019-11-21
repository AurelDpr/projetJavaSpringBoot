package com.cesi.projetJavaSpringBoot.repositories;

import com.cesi.projetJavaSpringBoot.entities.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Taches, Long> {
}
