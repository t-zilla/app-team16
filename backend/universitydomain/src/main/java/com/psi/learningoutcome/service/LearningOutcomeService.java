package com.psi.learningoutcome.service;

import com.psi.learningoutcome.model.MinisterialLearningOutcome;
import com.psi.learningoutcome.repository.DegreeCourseLearningOutcomeRepository;
import com.psi.learningoutcome.repository.MinisterialLearningOutcomeRepository;
import com.psi.learningoutcome.repository.SubjectLearningOutcomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningOutcomeService {

    private final MinisterialLearningOutcomeRepository ministerialLearningOutcomeRepository;
    private final SubjectLearningOutcomeRepository subjectLearningOutcomeRepository;
    private final DegreeCourseLearningOutcomeRepository degreeCourseLearningOutcomeRepository;

    public List<MinisterialLearningOutcome> getMinisterialLearningOutcomes() {
        return ministerialLearningOutcomeRepository.findAll();
    }
}
