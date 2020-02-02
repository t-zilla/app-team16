package com.psi.learningoutcome.translator;

import com.psi.learningoutcome.dto.DegreeCourseLearningOutcomeDto;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeDto;
import com.psi.learningoutcome.dto.SubjectLearningOutcomeDto;
import com.psi.learningoutcome.model.DegreeCourseLearningOutcome;
import com.psi.learningoutcome.model.MinisterialLearningOutcome;
import com.psi.learningoutcome.model.SubjectLearningOutcome;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class LearningOutcomeTranslator {

    public MinisterialLearningOutcomeDto toMinisterialLearningOutcomeDto(MinisterialLearningOutcome entity) {
        return MinisterialLearningOutcomeDto.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .description(entity.getDescription())
                .learningOutcomeType(entity.getLearningOutcomeType())
                .krkLevel(entity.getKrkLevel())
                .learningOutcomeArea(entity.getLearningOutcomeArea())
                .build();
    }

    public List<MinisterialLearningOutcomeDto> toMinisterialLearningOutcomeDto(List<MinisterialLearningOutcome> entities) {
        return entities.stream().map(LearningOutcomeTranslator::toMinisterialLearningOutcomeDto).collect(Collectors.toList());
    }

    public DegreeCourseLearningOutcomeDto toDegreeCourseLearningOutcomeDto(DegreeCourseLearningOutcome entity) {
        return DegreeCourseLearningOutcomeDto.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .description(entity.getDescription())
                .learningOutcomeType(entity.getLearningOutcomeType())
                .build();
    }

    public List<DegreeCourseLearningOutcomeDto> toDegreeCourseLearningOutcomeDto(List<DegreeCourseLearningOutcome> entities) {
        return entities.stream().map(LearningOutcomeTranslator::toDegreeCourseLearningOutcomeDto).collect(Collectors.toList());
    }

    public SubjectLearningOutcomeDto toSubjectLearningOutcomeDto(SubjectLearningOutcome entity) {
        return SubjectLearningOutcomeDto.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .description(entity.getDescription())
                .learningOutcomeType(entity.getLearningOutcomeType())
                .build();
    }

    public List<SubjectLearningOutcomeDto> toSubjectLearningOutcomeDto(List<SubjectLearningOutcome> entities) {
        return entities.stream().map(LearningOutcomeTranslator::toSubjectLearningOutcomeDto).collect(Collectors.toList());
    }
}
