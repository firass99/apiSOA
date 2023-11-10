package com.restsoa.services;

import java.util.List;

import com.restsoa.entities.Etudiant;

public interface EtudiantServices {

    Etudiant saveEtudiant(Etudiant etudiant);

    List<Etudiant> fetchAllEtudiant();

    Etudiant getEtudiantById(int id);

    Etudiant updateEtudiantById(int id, Etudiant etudiant);

    String deleteEtudiantById(int id);
}