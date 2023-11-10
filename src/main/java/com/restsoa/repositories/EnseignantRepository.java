package com.restsoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restsoa.entities.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
}
