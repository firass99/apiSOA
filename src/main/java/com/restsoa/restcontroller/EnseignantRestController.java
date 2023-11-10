package com.restsoa.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restsoa.entities.Enseignant;
import com.restsoa.services.EnseignantServices;

import java.util.List;

@RestController
public class EnseignantRestController {

    @Autowired
    private EnseignantServices enseignantServices;

    @PostMapping("/enseignant")
    public Enseignant saveEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantServices.saveEnseignant(enseignant);
    }

    @GetMapping("/enseignants")
    public List<Enseignant> getAllEnseignant() {
        return enseignantServices.fetchAllEnseignant();
    }

    @GetMapping("/enseignant/{id}")
    public Enseignant getEnseignantById(@PathVariable("id") int id) {
        return enseignantServices.getEnseignantById(id);
    }

    @PutMapping("/enseignant/{id}")
    public Enseignant updateEnseignant(@PathVariable("id") int id, @RequestBody Enseignant enseignant) {
        return enseignantServices.updateEnseignantById(id, enseignant);
    }

    @DeleteMapping("/enseignant/{id}")
    public String deleteEnseignant(@PathVariable("id") int id) {
        return enseignantServices.deleteEnseignantById(id);
    }
}