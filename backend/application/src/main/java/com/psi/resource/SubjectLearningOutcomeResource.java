package com.psi.resource;

import com.psi.handler.LearningOutcomeHandler;
import com.psi.learningoutcome.dto.SubjectLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.SubjectLearningOutcomeDto;
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
@RequestMapping("/api/subject-learning-outcome")
@RequiredArgsConstructor
public class SubjectLearningOutcomeResource {

    private final LearningOutcomeHandler learningOutcomeHandler;

    @GetMapping
    public List<SubjectLearningOutcomeDto> getSubjectLearningOutcomes() {
        return learningOutcomeHandler.getSubjectLearningOutcomes();
    }

    @GetMapping("/{id}")
    public SubjectLearningOutcomeDto getSubjectLearningOutcome(@PathVariable("id") Long id) {
        return learningOutcomeHandler.getSubjectLearningOutcome(id);
    }

    @PostMapping
    public SubjectLearningOutcomeDto createSubjectLearningOutcome(@RequestBody SubjectLearningOutcomeCreationDto dto) {
        return learningOutcomeHandler.createSubjectLearningOutcome(dto);
    }

    @PutMapping("/{id}")
    public SubjectLearningOutcomeDto updateSubjectLearningOutcome(@PathVariable("id") Long id,
                                                                  @RequestBody SubjectLearningOutcomeCreationDto dto) {
        return learningOutcomeHandler.updateSubjectLearningOutcome(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeSubjectLearningOutcomes(@PathVariable("id") Long id) {
        learningOutcomeHandler.removeSubjectLearningOutcome(id);
    }
}
