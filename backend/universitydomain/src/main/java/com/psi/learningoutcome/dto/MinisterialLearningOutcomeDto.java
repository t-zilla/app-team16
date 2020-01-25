package com.psi.learningoutcome.dto;

import com.psi.learningoutcome.model.KrkLevel;
import com.psi.learningoutcome.model.LearningOutcomeArea;
import com.psi.learningoutcome.model.LearningOutcomeType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MinisterialLearningOutcomeDto {

    private Long id;
    private String symbol;
    private String description;
    private LearningOutcomeType learningOutcomeType;
    private KrkLevel krkLevel;
    private LearningOutcomeArea learningOutcomeArea;
}
