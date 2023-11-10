package com.restsoa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restsoa.entities.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {
}
