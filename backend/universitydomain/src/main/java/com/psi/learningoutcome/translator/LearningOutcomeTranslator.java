package com.psi.learningoutcome.translator;

import com.psi.learningoutcome.dto.MinisterialLearningOutcomeDto;
import com.psi.learningoutcome.model.MinisterialLearningOutcome;
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
}
