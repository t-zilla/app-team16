package com.psi.researcher.translator;

import com.psi.researcher.dto.ResearcherDto;
import com.psi.researcher.model.Researcher;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ResearcherTranslator {

    public ResearcherDto toDto(Researcher entity) {
        return ResearcherDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .academicDegree(entity.getAcademicDegree())
                .position(entity.getPosition())
                .build();
    }

    public List<ResearcherDto> toDto(List<Researcher> entities) {
        return entities.stream().map(ResearcherTranslator::toDto).collect(Collectors.toList());
    }
}
