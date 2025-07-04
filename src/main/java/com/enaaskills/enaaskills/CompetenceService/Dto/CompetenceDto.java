package com.enaaskills.enaaskills.CompetenceService.Dto;

import java.util.List;

public class CompetenceDto {
    private Long id;
    private String name;
    private String description;

    private List<SousCompetenceDto> sousCompetences;

    private boolean estValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SousCompetenceDto> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetenceDto> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }

    public boolean isEstValid() {
        return estValid;
    }

    public void setEstValid(boolean estValid) {
        this.estValid = estValid;
    }
}
