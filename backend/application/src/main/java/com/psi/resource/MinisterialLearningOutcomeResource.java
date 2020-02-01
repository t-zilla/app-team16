package com.psi.resource;

import com.psi.handler.LearningOutcomeHandler;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ministerial-learning-outcomes")
@RequiredArgsConstructor
public class MinisterialLearningOutcomeResource implements RestResource {

    private final LearningOutcomeHandler learningOutcomeHandler;

    @GetMapping
    public List<MinisterialLearningOutcomeDto> geMinisterialLearningOutcomes() {
        return learningOutcomeHandler.getMinisterialLearningOutcomes();
    }

    @GetMapping("/{id}")
    public MinisterialLearningOutcomeDto getMinisterialLearningOutcome(@PathVariable("id") Long id) {
        return learningOutcomeHandler.getMinisterialLearningOutcome(id);
    }

    @PostMapping
    public MinisterialLearningOutcomeDto createMinisterialLearningOutcome(@RequestBody MinisterialLearningOutcomeCreationDto dto) {
        return learningOutcomeHandler.createMinisterialLearningOutcome(dto);
    }

    @PutMapping("/{id}")
    public MinisterialLearningOutcomeDto updateMinisterialLearningOutcome(@PathVariable("id") Long id,
                                                                          @RequestBody MinisterialLearningOutcomeCreationDto dto) {
        return learningOutcomeHandler.updateMinisterialLearningOutcome(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeMinisterialLearningOutcome(@PathVariable("id") Long id) {
        learningOutcomeHandler.removeMinisterialLearningOutcome(id);
    }

}
