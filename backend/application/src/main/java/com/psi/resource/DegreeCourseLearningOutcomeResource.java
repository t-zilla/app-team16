package com.psi.resource;

import com.psi.handler.LearningOutcomeHandler;
import com.psi.learningoutcome.dto.DegreeCourseLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.DegreeCourseLearningOutcomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/degree-course-learning-outcome")
@RequiredArgsConstructor
public class DegreeCourseLearningOutcomeResource {

    private final LearningOutcomeHandler learningOutcomeHandler;

    @GetMapping
    public List<DegreeCourseLearningOutcomeDto> getDegreeCourseLearningOutcomes(@RequestParam(value = "syllabusId", required = false) Long syllabusId) {
        return learningOutcomeHandler.getDegreeCourseLearningOutcomes(syllabusId);
    }

    @GetMapping("/{id}")
    public DegreeCourseLearningOutcomeDto getDegreeCourseLearningOutcome(@PathVariable("id") Long id) {
        return learningOutcomeHandler.getDegreeCourseLearningOutcome(id);
    }

    @PostMapping
    public DegreeCourseLearningOutcomeDto createDegreeCourseLearningOutcome(@RequestBody DegreeCourseLearningOutcomeCreationDto dto) {
        return learningOutcomeHandler.createDegreeCourseLearningOutcome(dto);
    }

    @PutMapping("/{id}")
    public DegreeCourseLearningOutcomeDto updateDegreeCourseLearningOutcome(@PathVariable("id") Long id,
                                                                            @RequestBody DegreeCourseLearningOutcomeCreationDto dto) {
        return learningOutcomeHandler.updateDegreeCourseLearningOutcome(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeDegreeCourseLearningOutcome(@PathVariable("id") Long id) {
        learningOutcomeHandler.removeDegreeCourseLearningOutcome(id);
    }
}
