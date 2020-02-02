package com.psi.learningoutcome.repository;

import com.psi.learningoutcome.model.DegreeCourseLearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeCourseLearningOutcomeRepository extends JpaRepository<DegreeCourseLearningOutcome, Long>,
        JpaSpecificationExecutor<DegreeCourseLearningOutcome> {
}
