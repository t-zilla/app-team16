package com.psi.resource;

import com.psi.handler.LearningOutcomeHandler;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ministerial-learning-outcomes")
@RequiredArgsConstructor
public class MinisterialLearningOutcomeResource {

    private final LearningOutcomeHandler handler;

    @GetMapping
    public List<MinisterialLearningOutcomeDto> geMinisterialLearningOutcomes() {
        return handler.getMinisterialLearningOutcomes();
    }

}
