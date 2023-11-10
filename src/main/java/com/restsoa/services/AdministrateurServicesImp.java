package com.restsoa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restsoa.entities.Administrateur;
import com.restsoa.repositories.AdministrateurRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdministrateurServicesImp implements AdministrateurServices{

    @Autowired
    private AdministrateurRepository administrateurRepository;

    @Override
    public Administrateur saveAdministrateur(Administrateur Administrateur) {
        return administrateurRepository.save(Administrateur);
    }

    @Override
    public List<Administrateur> fetchAllAdministrateur() {
        List<Administrateur> allAdministrateurs = administrateurRepository.findAll();
        return allAdministrateurs;
    }

    @Override
    public Administrateur getAdministrateurById(int id) {
        Optional<Administrateur> administrateur = administrateurRepository.findById(id);
        if (administrateur.isPresent()) {
            return administrateur.get();
        }
        return null;
    }

    @Override
    public Administrateur updateAdministrateurById(int id, Administrateur administrateur) {
        Optional<Administrateur> administrateur1 = administrateurRepository.findById(id);

        if (administrateur1.isPresent()) {
        	Administrateur originalAdministrateur = administrateur1.get();

            if (Objects.nonNull(administrateur.getNom()) && !"".equalsIgnoreCase(administrateur.getNom())) {
                originalAdministrateur.setNom(administrateur.getNom());
            }
            if (Objects.nonNull(administrateur.getPrenom()) && !"".equalsIgnoreCase(administrateur.getPrenom())) {
                originalAdministrateur.setPrenom(administrateur.getPrenom());
            }
            if (administrateur.getAge() != null) {
                originalAdministrateur.setAge(administrateur.getAge());
            }
            if (administrateur.getCin() != null) {
                originalAdministrateur.setCin(administrateur.getCin());
            }
            if (administrateur.getTel() != null) {
                originalAdministrateur.setTel(administrateur.getTel());
            }
            if (Objects.nonNull(administrateur.getDep()) && !"".equalsIgnoreCase(administrateur.getDep())) {
                originalAdministrateur.setDep(administrateur.getDep());
            }
            if (administrateur.getNb_abs() != null) {
                originalAdministrateur.setNb_abs(administrateur.getNb_abs());
            }
            
            return administrateurRepository.save(originalAdministrateur);
        }
        return null;
    }

    @Override
    public String deleteAdministrateurById(int id) {
        if (administrateurRepository.findById(id).isPresent()) {
        	administrateurRepository.deleteById(id);
            return "Administrateur deleted successfully";
        }
        return "Invalid Administrateur";
    }
}