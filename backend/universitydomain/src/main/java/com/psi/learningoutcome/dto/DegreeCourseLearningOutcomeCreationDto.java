package com.psi.learningoutcome.dto;

import com.psi.learningoutcome.model.LearningOutcomeType;
import lombok.Getter;

@Getter
public class DegreeCourseLearningOutcomeCreationDto {

    private String symbol;
    private String description;
    private LearningOutcomeType learningOutcomeType;
}
