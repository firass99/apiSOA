package com.restsoa.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private Date age;
    private Integer cin;
    private Integer nb_abs;
    private Boolean reussi;

    // Getters and setters for each field
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }
    
    
    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public Integer getNb_abs() {
        return nb_abs;
    }

    public void setNb_abs(Integer nb_abs) {
        this.nb_abs = nb_abs;
    }

    public Boolean getReussi() {
        return reussi;
    }

    public void setReussi(Boolean reussi) {
        this.reussi = reussi;
    }
}
