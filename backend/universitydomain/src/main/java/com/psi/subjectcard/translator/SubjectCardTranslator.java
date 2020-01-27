package com.psi.subjectcard.translator;

import com.psi.subjectcard.dto.SubjectCardDto;
import com.psi.subjectcard.model.SubjectCard;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SubjectCardTranslator {

    public static SubjectCardDto toDto(SubjectCard entity) {
        return SubjectCardDto.builder()
                .id(entity.getId())
                .objectives(entity.getObjectives())
                .entryRequirements(entity.getEntryRequirements())
                .teachingTools(entity.getTeachingTools())
                .basicLiterature(entity.getBasicLiterature())
                .supplementaryLiterature(entity.getSupplementaryLiterature())
                .build();
    }

    public static List<SubjectCardDto> toDto(List<SubjectCard> entities) {
        return entities.stream().map(SubjectCardTranslator::toDto).collect(Collectors.toList());
    }
}
