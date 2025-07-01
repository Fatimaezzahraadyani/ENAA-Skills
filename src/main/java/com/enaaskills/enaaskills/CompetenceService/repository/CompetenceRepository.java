package com.enaaskills.enaaskills.CompetenceService.repository;

import com.enaaskills.enaaskills.CompetenceService.Model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
