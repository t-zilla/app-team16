package com.psi.subject.translator;

import com.psi.subject.dto.SubjectDto;
import com.psi.subject.model.Subject;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SubjectTranslator {

    public SubjectDto toDto(Subject entity) {
        return SubjectDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .polishName(entity.getPolishName())
                .englishName(entity.getEnglishName())
                .subjectLearningArea(entity.getSubjectLearningArea())
                .ectsSum(entity.getEctsSum())
                .cnpsSum(entity.getCnpsSum())
                .zzuSum(entity.getZzuSum())
                .build();
    }

    public List<SubjectDto> toDto(List<Subject> entities) {
        return entities.stream().map(SubjectTranslator::toDto).collect(Collectors.toList());
    }
}
