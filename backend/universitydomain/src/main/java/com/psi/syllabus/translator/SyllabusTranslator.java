package com.psi.syllabus.translator;

import com.psi.syllabus.dto.SyllabusDto;
import com.psi.syllabus.model.Syllabus;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SyllabusTranslator {

    public SyllabusDto toDto(Syllabus entity) {
        return SyllabusDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .studyDegree(entity.getStudyDegree())
                .studyForm(entity.getStudyForm())
                .learningProfile(entity.getLearningProfile())
                .termAmount(entity.getTermAmount())
                .entryRequirements(entity.getEntryRequirements())
                .professionalTitle(entity.getProfessionalTitle())
                .graduationForm(entity.getGraduationForm())
                .graduateSilhouette(entity.getGraduateSilhouette())
                .cnpsMultiplier(entity.getCnpsMultiplier())
                .extendedTermAmount(entity.getExtendedTermAmount())
                .examIssues(entity.getExamIssues())
                .build();
    }

    public List<SyllabusDto> toDto(List<Syllabus> entities) {
        return entities.stream().map(SyllabusTranslator::toDto).collect(Collectors.toList());
    }
}
