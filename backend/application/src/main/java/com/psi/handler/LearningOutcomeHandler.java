package com.psi.handler;

import com.psi.learningoutcome.dto.DegreeCourseLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.DegreeCourseLearningOutcomeDto;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeDto;
import com.psi.learningoutcome.dto.SubjectLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.SubjectLearningOutcomeDto;
import com.psi.learningoutcome.repository.DegreeCourseLearningOutcomeSpecification;
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

    public List<DegreeCourseLearningOutcomeDto> getDegreeCourseLearningOutcomes(Long syllabusId) {
        return LearningOutcomeTranslator.toDegreeCourseLearningOutcomeDto(
                service.getDegreeCourseLearningOutcomes(new DegreeCourseLearningOutcomeSpecification(syllabusId)));
    }

    public List<SubjectLearningOutcomeDto> getSubjectLearningOutcomes() {
        return LearningOutcomeTranslator.toSubjectLearningOutcomeDto(service.getSubjectLearningOutcomes());
    }

    public MinisterialLearningOutcomeDto getMinisterialLearningOutcome(Long id) {
        return LearningOutcomeTranslator.toMinisterialLearningOutcomeDto(service.getMinisterialLearningOutcome(id));
    }

    public DegreeCourseLearningOutcomeDto getDegreeCourseLearningOutcome(Long id) {
        return LearningOutcomeTranslator.toDegreeCourseLearningOutcomeDto(service.getDegreeCourseLearningOutcome(id));
    }

    public SubjectLearningOutcomeDto getSubjectLearningOutcome(Long id) {
        return LearningOutcomeTranslator.toSubjectLearningOutcomeDto(service.getSubjectLearningOutcome(id));
    }

    public MinisterialLearningOutcomeDto createMinisterialLearningOutcome(MinisterialLearningOutcomeCreationDto dto) {
        return LearningOutcomeTranslator.toMinisterialLearningOutcomeDto(service.createMinisterialLearningOutcome(dto));
    }

    public DegreeCourseLearningOutcomeDto createDegreeCourseLearningOutcome(DegreeCourseLearningOutcomeCreationDto dto) {
        return LearningOutcomeTranslator.toDegreeCourseLearningOutcomeDto(service.createDegreeCourseLearningOutcome(dto));
    }

    public SubjectLearningOutcomeDto createSubjectLearningOutcome(SubjectLearningOutcomeCreationDto dto) {
        return LearningOutcomeTranslator.toSubjectLearningOutcomeDto(service.createSubjectLearningOutcome(dto));
    }

    public MinisterialLearningOutcomeDto updateMinisterialLearningOutcome(Long id, MinisterialLearningOutcomeCreationDto dto) {
        return LearningOutcomeTranslator.toMinisterialLearningOutcomeDto(service.updateMinisterialLearningOutcome(id, dto));
    }

    public DegreeCourseLearningOutcomeDto updateDegreeCourseLearningOutcome(Long id, DegreeCourseLearningOutcomeCreationDto dto) {
        return LearningOutcomeTranslator.toDegreeCourseLearningOutcomeDto(service.updateDegreeCourseLearningOutcome(id, dto));
    }

    public SubjectLearningOutcomeDto updateSubjectLearningOutcome(Long id, SubjectLearningOutcomeCreationDto dto) {
        return LearningOutcomeTranslator.toSubjectLearningOutcomeDto(service.updateSubjectLearningOutcome(id, dto));
    }

    public void removeMinisterialLearningOutcome(Long id) {
        service.removeMinisterialLearningOutcome(id);
    }

    public void removeDegreeCourseLearningOutcome(Long id) {
        service.removeDegreeCourseLearningOutcome(id);
    }

    public void removeSubjectLearningOutcome(Long id) {
        service.removeSubjectLearningOutcome(id);
    }

}
