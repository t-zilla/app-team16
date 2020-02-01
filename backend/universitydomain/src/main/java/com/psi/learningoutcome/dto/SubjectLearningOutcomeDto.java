package com.psi.learningoutcome.dto;

import com.psi.learningoutcome.model.LearningOutcomeType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectLearningOutcomeDto {

    private Long id;
    private String symbol;
    private String description;
    private LearningOutcomeType learningOutcomeType;
}
