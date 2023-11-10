package com.restsoa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restsoa.entities.Enseignant;
import com.restsoa.repositories.EnseignantRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EnseignantServicesImp implements EnseignantServices{

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public List<Enseignant> fetchAllEnseignant() {
        List<Enseignant> allEnseignants = enseignantRepository.findAll();
        return allEnseignants;
    }

    @Override
    public Enseignant getEnseignantById(int id) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (enseignant.isPresent()) {
            return enseignant.get();
        }
        return null;
    }

    @Override
    public Enseignant updateEnseignantById(int id, Enseignant enseignant) {
        Optional<Enseignant> enseignant1 = enseignantRepository.findById(id);

        if (enseignant1.isPresent()) {
            Enseignant originalEnseignant = enseignant1.get();

            if (Objects.nonNull(enseignant.getNom()) && !"".equalsIgnoreCase(enseignant.getNom())) {
                originalEnseignant.setNom(enseignant.getNom());
            }
            if (Objects.nonNull(enseignant.getPrenom()) && !"".equalsIgnoreCase(enseignant.getPrenom())) {
                originalEnseignant.setPrenom(enseignant.getPrenom());
            }
            if (enseignant.getAge() != null) {
                originalEnseignant.setAge(enseignant.getAge());
            }
            if (enseignant.getCin() != null) {
                originalEnseignant.setCin(enseignant.getCin());
            }
            if (enseignant.getTel() != null) {
                originalEnseignant.setTel(enseignant.getTel());
            }
            if (Objects.nonNull(enseignant.getMatiere()) && !"".equalsIgnoreCase(enseignant.getMatiere())) {
                originalEnseignant.setMatiere(enseignant.getMatiere());
            }
            if (enseignant.getNb_abs() != null) {
                originalEnseignant.setNb_abs(enseignant.getNb_abs());
            }
            
            return enseignantRepository.save(originalEnseignant);
        }
        return null;
    }

    @Override
    public String deleteEnseignantById(int id) {
        if (enseignantRepository.findById(id).isPresent()) {
            enseignantRepository.deleteById(id);
            return "Enseignant deleted successfully";
        }
        return "Invalid Enseignant";
    }
}