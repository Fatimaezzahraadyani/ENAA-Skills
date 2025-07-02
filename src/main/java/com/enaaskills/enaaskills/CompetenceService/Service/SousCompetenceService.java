package com.enaaskills.enaaskills.CompetenceService.Service;


import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;
import com.enaaskills.enaaskills.CompetenceService.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;

@Service
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository) {
        this.sousCompetenceRepository = sousCompetenceRepository;
    }

    public SousCompetence validerSousCompetence(Long id) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));
        sc.setEstValide(true);
        return sousCompetenceRepository.save(sc);
    }

}
