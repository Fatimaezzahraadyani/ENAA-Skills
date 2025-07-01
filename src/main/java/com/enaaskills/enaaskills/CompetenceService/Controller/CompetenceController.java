package com.enaaskills.enaaskills.CompetenceService.Controller;


import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import com.enaaskills.enaaskills.CompetenceService.Service.CompetenceService;
import com.enaaskills.enaaskills.CompetenceService.repository.CompetenceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Competences")
public class CompetenceController {


    private final CompetenceService competenceService;
    private final CompetenceRepository competenceRepository;


    public CompetenceController(CompetenceService competenceService, CompetenceRepository competenceRepository) {
        this.competenceService = competenceService;
        this.competenceRepository = competenceRepository;
    }

    @GetMapping("/all")
    public List<Competence> getAllCompetences() {
        return competenceService.getAllCompetences();
    }

    @PostMapping("/add")
    public ResponseEntity<Competence> createCompetence(@RequestBody Competence competence) {
        Competence created = competenceService.createCompetence(competence);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competence> getCompetenceById(@PathVariable Long id) {
        return ResponseEntity.ok(competenceService.getCompetenceById(id));
    }



    @PutMapping("/edit/{id}")
    public ResponseEntity<Competence> updateCompetence(@PathVariable Long id, @RequestBody Competence competence) {
        Competence updated = competenceService.updateCompetence(id, competence);
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
        return ResponseEntity.noContent().build();
    }

}
