package com.enaaskills.enaaskills.CompetenceService.Controller;


import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;
import com.enaaskills.enaaskills.CompetenceService.Service.SousCompetenceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sous-competences")
public class SousCompetenceController {

    private final SousCompetenceService sousCompetenceService;

    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PutMapping("/{id}/valider")
    public SousCompetence validerSousCompetence(@PathVariable Long id) {
        return sousCompetenceService.validerSousCompetence(id);
    }
}
