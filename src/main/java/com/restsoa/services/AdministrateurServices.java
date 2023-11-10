package com.restsoa.services;

import java.util.List;
import com.restsoa.entities.Administrateur;

public interface AdministrateurServices {

	Administrateur saveAdministrateur(Administrateur administrateur);

    List<Administrateur> fetchAllAdministrateur();

    Administrateur getAdministrateurById(int id);

    Administrateur updateAdministrateurById(int id, Administrateur administrateur);

    String deleteAdministrateurById(int id);
}