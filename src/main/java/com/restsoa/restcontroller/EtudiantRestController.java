package com.restsoa.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restsoa.entities.Etudiant;
import com.restsoa.services.EtudiantServices;

import java.util.List;

@RestController
public class EtudiantRestController {

    @Autowired
    private EtudiantServices etudiantServices;

    @PostMapping("/etudiant")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServices.saveEtudiant(etudiant);
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.fetchAllEtudiant();
    }

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") int id) {
        return etudiantServices.getEtudiantById(id);
    }

    @PutMapping("/etudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") int id, @RequestBody Etudiant etudiant) {
        return etudiantServices.updateEtudiantById(id, etudiant);
    }

    @DeleteMapping("/etudiant/{id}")
    public String deleteETudiant(@PathVariable("id") int id) {
        return etudiantServices.deleteEtudiantById(id);
    }
}