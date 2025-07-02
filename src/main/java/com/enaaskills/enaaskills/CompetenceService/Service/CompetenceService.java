package com.enaaskills.enaaskills.CompetenceService.Service;

import com.enaaskills.enaaskills.CompetenceService.Dto.CompetenceDto;
import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import com.enaaskills.enaaskills.CompetenceService.mapper.CompetenceMapper;
import com.enaaskills.enaaskills.CompetenceService.mapper.CompetenceMapperImpl;
import com.enaaskills.enaaskills.CompetenceService.repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    public CompetenceService (CompetenceRepository competenceRepository, CompetenceRepository competenceRepository1, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
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


    public CompetenceDto getCompetenceDtoById(Long id) {
        Competence competence = competenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compétence non trouvée"));
        return competenceMapper.competenceToDto(competence);
    }

}
