package com.restsoa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restsoa.entities.Etudiant;
import com.restsoa.repositories.EtudiantRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EtudiantServicesImp implements EtudiantServices{

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> fetchAllEtudiant() {
        List<Etudiant> allEtudiants = etudiantRepository.findAll();
        return allEtudiants;
    }

    @Override
    public Etudiant getEtudiantById(int id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if (etudiant.isPresent()) {
            return etudiant.get();
        }
        return null;
    }

    @Override
    public Etudiant updateEtudiantById(int id, Etudiant etudiant) {
        Optional<Etudiant> etudiant1 = etudiantRepository.findById(id);

        if (etudiant1.isPresent()) {
            Etudiant originalEtudiant = etudiant1.get();

            if (Objects.nonNull(etudiant.getNom()) && !"".equalsIgnoreCase(etudiant.getNom())) {
                originalEtudiant.setNom(etudiant.getNom());
            }
            if (Objects.nonNull(etudiant.getPrenom()) && !"".equalsIgnoreCase(etudiant.getPrenom())) {
                originalEtudiant.setPrenom(etudiant.getPrenom());
            }
            if (etudiant.getAge() != null) {
                originalEtudiant.setAge(etudiant.getAge());
            }
            if (etudiant.getCin() != null) {
                originalEtudiant.setCin(etudiant.getCin());
            }
            if (etudiant.getNb_abs() != null) {
                originalEtudiant.setNb_abs(etudiant.getNb_abs());
            }
            if (etudiant.getReussi() != null) {
                originalEtudiant.setReussi(etudiant.getReussi());
            }
            
            return etudiantRepository.save(originalEtudiant);
        }
        return null;
    }

    @Override
    public String deleteEtudiantById(int id) {
        if (etudiantRepository.findById(id).isPresent()) {
            etudiantRepository.deleteById(id);
            return "Etudiant deleted successfully";
        }
        return "Invalid Student";
    }
}