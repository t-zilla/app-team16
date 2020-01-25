package com.psi.handler;

import com.psi.learningoutcome.dto.MinisterialLearningOutcomeDto;
import com.psi.learningoutcome.service.LearningOutcomeService;
import com.psi.learningoutcome.translator.LearningOutcomeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LearningOutcomeHandler {

    private final LearningOutcomeService service;

    public List<MinisterialLearningOutcomeDto> getMinisterialLearningOutcomes() {
        return LearningOutcomeTranslator.toMinisterialLearningOutcomeDto(service.getMinisterialLearningOutcomes());
    }
}
