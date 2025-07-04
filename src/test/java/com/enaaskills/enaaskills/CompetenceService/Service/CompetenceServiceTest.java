package com.enaaskills.enaaskills.CompetenceService.Service;

import com.enaaskills.enaaskills.CompetenceService.Dto.CompetenceDto;
import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;
import com.enaaskills.enaaskills.CompetenceService.mapper.CompetenceMapper;
import com.enaaskills.enaaskills.CompetenceService.repository.CompetenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.verification.VerificationMode;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetenceServiceTest {

    private CompetenceService competenceService;
    private CompetenceRepository competenceRepository;
    private CompetenceMapper competenceMapper;

    @BeforeEach
    void setUp() {
        competenceRepository = mock(CompetenceRepository.class);
        competenceMapper = mock(CompetenceMapper.class);
        competenceService = new CompetenceService(competenceRepository, competenceMapper);
    }
    @Test
    void createCompetence() {

    }

    @Test
    void getAllCompetences() {
    }

    @Test
    void getCompetenceById() {
    }

    @Test
    void updateCompetence() {
    }

    @Test
    void deleteCompetence() {

    }

    @Test
    void getCompetenceDtoById() {
        Competence comp = new Competence();
        comp.setId(2L);
        comp.setNom("Compétence technique");

        CompetenceDto dto = new CompetenceDto();
        dto.setName("Compétence technique");

        when(competenceRepository.findById(2L)).thenReturn(Optional.of(comp));
        when(competenceMapper.competenceToDto(comp)).thenReturn(dto);

        CompetenceDto result = competenceService.getCompetenceDtoById(2L);

        assertEquals("Compétence technique", result.getName());
    }
}