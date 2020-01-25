package com.psi.learningoutcome.repository;

import com.psi.learningoutcome.model.MinisterialLearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinisterialLearningOutcomeRepository extends JpaRepository<MinisterialLearningOutcome, Long> {
}
