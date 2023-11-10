package com.restsoa.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restsoa.entities.Administrateur;
import com.restsoa.services.AdministrateurServices;

import java.util.List;

@RestController
public class AdministrateurRestController {

    @Autowired
    private AdministrateurServices administrateurServices;

    @PostMapping("/admin")
    public Administrateur saveAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurServices.saveAdministrateur(administrateur);
    }

    @GetMapping("/admins")
    public List<Administrateur> getAllAdministrateur() {
        return administrateurServices.fetchAllAdministrateur();
    }

    @GetMapping("/admin/{id}")
    public Administrateur getAdministrateurById(@PathVariable("id") int id) {
        return administrateurServices.getAdministrateurById(id);
    }

    @PutMapping("/admin/{id}")
    public Administrateur updateAdministrateur(@PathVariable("id") int id, @RequestBody Administrateur administrateur) {
        return administrateurServices.updateAdministrateurById(id, administrateur);
    }

    @DeleteMapping("/admin/{id}")
    public String deleteAdministrateur(@PathVariable("id") int id) {
        return administrateurServices.deleteAdministrateurById(id);
    }
}