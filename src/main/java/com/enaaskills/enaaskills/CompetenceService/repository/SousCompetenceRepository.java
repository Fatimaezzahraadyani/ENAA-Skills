package com.enaaskills.enaaskills.CompetenceService.repository;


import com.enaaskills.enaaskills.CompetenceService.Model.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {


}
