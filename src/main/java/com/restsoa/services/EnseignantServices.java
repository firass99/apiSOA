package com.restsoa.services;

import java.util.List;

import com.restsoa.entities.Enseignant;

public interface EnseignantServices {

    Enseignant saveEnseignant(Enseignant enseignant);

    List<Enseignant> fetchAllEnseignant();

    Enseignant getEnseignantById(int id);

    Enseignant updateEnseignantById(int id, Enseignant enseignant);

    String deleteEnseignantById(int id);
}