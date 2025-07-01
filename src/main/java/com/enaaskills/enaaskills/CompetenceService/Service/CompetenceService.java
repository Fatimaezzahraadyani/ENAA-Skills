package com.enaaskills.enaaskills.CompetenceService.Service;

import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import com.enaaskills.enaaskills.CompetenceService.repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public Competence createCompetence(Competence competence) {
        if(competence.getSousCompetences() != null){
            competence.getSousCompetences().forEach(sc-> sc.setCompetence(competence));
        }
        return competenceRepository.save(competence);
    }

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Competence getCompetenceById(Long id) {
        return competenceRepository.findById(id).orElseThrow(()-> new RuntimeException("Competence not found"));
    }

    public Competence updateCompetence(Long id, Competence UpdatedCompetence) {
        Competence exist = getCompetenceById(id);
        exist.setNom(UpdatedCompetence.getNom());
        exist.setDescription(UpdatedCompetence.getDescription());
        exist.setSousCompetences(UpdatedCompetence.getSousCompetences());
        return competenceRepository.save(exist);
    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }



}
