package com.psi.learningoutcome.service;

import com.psi.common.CommonUtil;
import com.psi.learningoutcome.dto.DegreeCourseLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.MinisterialLearningOutcomeCreationDto;
import com.psi.learningoutcome.dto.SubjectLearningOutcomeCreationDto;
import com.psi.learningoutcome.model.DegreeCourseLearningOutcome;
import com.psi.learningoutcome.model.MinisterialLearningOutcome;
import com.psi.learningoutcome.model.SubjectLearningOutcome;
import com.psi.learningoutcome.repository.DegreeCourseLearningOutcomeRepository;
import com.psi.learningoutcome.repository.MinisterialLearningOutcomeRepository;
import com.psi.learningoutcome.repository.SubjectLearningOutcomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningOutcomeService {

    private final MinisterialLearningOutcomeRepository ministerialLearningOutcomeRepository;
    private final SubjectLearningOutcomeRepository subjectLearningOutcomeRepository;
    private final DegreeCourseLearningOutcomeRepository degreeCourseLearningOutcomeRepository;

    public List<MinisterialLearningOutcome> getMinisterialLearningOutcomes() {
        return ministerialLearningOutcomeRepository.findAll();
    }

    public List<DegreeCourseLearningOutcome> getDegreeCourseLearningOutcomes(Specification<DegreeCourseLearningOutcome> specification) {
        return degreeCourseLearningOutcomeRepository.findAll(specification);
    }

    public List<SubjectLearningOutcome> getSubjectLearningOutcomes() {
        return subjectLearningOutcomeRepository.findAll();
    }

    public MinisterialLearningOutcome getMinisterialLearningOutcome(Long id) {
        return ministerialLearningOutcomeRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, MinisterialLearningOutcome.class));
    }

    public DegreeCourseLearningOutcome getDegreeCourseLearningOutcome(Long id) {
        return degreeCourseLearningOutcomeRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, DegreeCourseLearningOutcome.class));
    }

    public SubjectLearningOutcome getSubjectLearningOutcome(Long id) {
        return subjectLearningOutcomeRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, SubjectLearningOutcome.class));
    }

    public MinisterialLearningOutcome createMinisterialLearningOutcome(MinisterialLearningOutcomeCreationDto dto) {
        MinisterialLearningOutcome ministerialLearningOutcome = MinisterialLearningOutcome.builder()
                .symbol(dto.getSymbol())
                .description(dto.getDescription())
                .learningOutcomeArea(dto.getLearningOutcomeArea())
                .learningOutcomeType(dto.getLearningOutcomeType())
                .krkLevel(dto.getKrkLevel())
                .build();

        return ministerialLearningOutcomeRepository.save(ministerialLearningOutcome);
    }

    public DegreeCourseLearningOutcome createDegreeCourseLearningOutcome(DegreeCourseLearningOutcomeCreationDto dto) {
        DegreeCourseLearningOutcome degreeCourseLearningOutcome = DegreeCourseLearningOutcome.builder()
                .description(dto.getDescription())
                .symbol(dto.getSymbol())
                .learningOutcomeType(dto.getLearningOutcomeType())
                .build();

        return degreeCourseLearningOutcomeRepository.save(degreeCourseLearningOutcome);
    }

    public SubjectLearningOutcome createSubjectLearningOutcome(SubjectLearningOutcomeCreationDto dto) {
        SubjectLearningOutcome subjectLearningOutcome = SubjectLearningOutcome.builder()
                .description(dto.getDescription())
                .symbol(dto.getSymbol())
                .learningOutcomeType(dto.getLearningOutcomeType())
                .build();

        return subjectLearningOutcomeRepository.save(subjectLearningOutcome);
    }

    @Transactional
    public MinisterialLearningOutcome updateMinisterialLearningOutcome(Long id, MinisterialLearningOutcomeCreationDto dto) {
        MinisterialLearningOutcome ministerialLearningOutcome = getMinisterialLearningOutcome(id);
        ministerialLearningOutcome.setSymbol(dto.getSymbol());
        ministerialLearningOutcome.setLearningOutcomeType(dto.getLearningOutcomeType());
        ministerialLearningOutcome.setDescription(dto.getDescription());
        ministerialLearningOutcome.setKrkLevel(dto.getKrkLevel());
        ministerialLearningOutcome.setLearningOutcomeArea(dto.getLearningOutcomeArea());

        return ministerialLearningOutcomeRepository.save(ministerialLearningOutcome);
    }

    @Transactional
    public DegreeCourseLearningOutcome updateDegreeCourseLearningOutcome(Long id, DegreeCourseLearningOutcomeCreationDto dto) {
        DegreeCourseLearningOutcome degreeCourseLearningOutcome = getDegreeCourseLearningOutcome(id);
        degreeCourseLearningOutcome.setSymbol(dto.getSymbol());
        degreeCourseLearningOutcome.setLearningOutcomeType(dto.getLearningOutcomeType());
        degreeCourseLearningOutcome.setDescription(dto.getDescription());

        return degreeCourseLearningOutcomeRepository.save(degreeCourseLearningOutcome);
    }

    @Transactional
    public SubjectLearningOutcome updateSubjectLearningOutcome(Long id, SubjectLearningOutcomeCreationDto dto) {
        SubjectLearningOutcome subjectLearningOutcome = getSubjectLearningOutcome(id);
        subjectLearningOutcome.setSymbol(dto.getSymbol());
        subjectLearningOutcome.setLearningOutcomeType(dto.getLearningOutcomeType());
        subjectLearningOutcome.setDescription(dto.getDescription());

        return subjectLearningOutcomeRepository.save(subjectLearningOutcome);
    }

    @Transactional
    public void removeMinisterialLearningOutcome(Long id) {
        MinisterialLearningOutcome ministerialLearningOutcome = getMinisterialLearningOutcome(id);
        ministerialLearningOutcomeRepository.delete(ministerialLearningOutcome);
    }


    @Transactional
    public void removeDegreeCourseLearningOutcome(Long id) {
        DegreeCourseLearningOutcome degreeCourseLearningOutcome = getDegreeCourseLearningOutcome(id);
        degreeCourseLearningOutcomeRepository.delete(degreeCourseLearningOutcome);
    }


    @Transactional
    public void removeSubjectLearningOutcome(Long id) {
        SubjectLearningOutcome subjectLearningOutcome = getSubjectLearningOutcome(id);
        subjectLearningOutcomeRepository.delete(subjectLearningOutcome);
    }

}
