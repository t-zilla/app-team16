package com.psi.learningoutcome.repository;

import com.psi.learningoutcome.model.SubjectLearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectLearningOutcomeRepository extends JpaRepository<SubjectLearningOutcome, Long> {
}
