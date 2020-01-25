package com.psi.speciality.translator;

import com.psi.speciality.dto.SpecialityDto;
import com.psi.speciality.model.Speciality;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SpecialityTranslator {

    public static SpecialityDto toDto(Speciality entity) {
        return SpecialityDto.of(entity.getId(), entity.getName());
    }

    public static List<SpecialityDto> toDto(List<Speciality> entities) {
        return entities.stream().map(SpecialityTranslator::toDto).collect(Collectors.toList());
    }
}
