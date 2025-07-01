package com.enaaskills.enaaskills.CompetenceService.Model;


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
    private List<Competence> SousCompetences;


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

    public List<Competence> getSousCompetences() {
        return SousCompetences;
    }

    public void setSousCompetences(List<Competence> sousCompetences) {
        SousCompetences = sousCompetences;
    }

    public void setCompetence(Competence competence) {}
}
