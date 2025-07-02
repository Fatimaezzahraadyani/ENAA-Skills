package com.enaaskills.enaaskills.CompetenceService.mapper;

import com.enaaskills.enaaskills.CompetenceService.Dto.CompetenceDto;
import com.enaaskills.enaaskills.CompetenceService.Dto.SousCompetenceDto;
import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CompetenceMapper {


    SousCompetenceDto sousCompetenceToDto(SousCompetence sousCompetence);

    List<SousCompetenceDto> sousCompetenceToDtos(List<SousCompetence> sousCompetences);

    @Mapping(
            target = "estValid" ,
            expression = "java(allSousCompetencesValide(competence.getSousCompetences()))"
    )
    @Mapping(
            target = "sousCompetences",
            source = "sousCompetences"
    )
    CompetenceDto competenceToDto(Competence competence);

    default boolean allSousCompetencesValide(List<SousCompetence> sousCompetences) {
        if (sousCompetences == null || sousCompetences.isEmpty())
            return false;
        return sousCompetences.stream().allMatch(SousCompetence::isEstValide);
    }


}
