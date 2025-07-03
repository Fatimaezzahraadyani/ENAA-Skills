package com.enaaskills.enaaskills.CompetenceService.Service;


import com.enaaskills.enaaskills.CompetenceService.Dto.CompetenceDto;
import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;
import com.enaaskills.enaaskills.CompetenceService.mapper.CompetenceMapper;
import com.enaaskills.enaaskills.CompetenceService.repository.CompetenceRepository;
import com.enaaskills.enaaskills.CompetenceService.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;

@Service
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository, CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.sousCompetenceRepository = sousCompetenceRepository;
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }

    public CompetenceDto validerSousCompetence(Long id) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));

        sc.setEstValide(true);
        sousCompetenceRepository.save(sc);

        // Recharger la compétence parente depuis la base
        Competence competence = competenceRepository.findById(sc.getCompetence().getId())
                .orElseThrow(() -> new RuntimeException("Compétence parente non trouvée"));

        // Retourner le DTO mis à jour avec estValidee recalculé
        return competenceMapper.competenceToDto(competence);
    }

}
