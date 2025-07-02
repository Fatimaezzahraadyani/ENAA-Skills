package com.enaaskills.enaaskills.CompetenceService.Model;
import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SousCompetence> sousCompetences;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SousCompetence> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetence> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }

    public void setCompetence(Competence competence) {}
}
