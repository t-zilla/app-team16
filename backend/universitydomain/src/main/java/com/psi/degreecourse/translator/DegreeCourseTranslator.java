package com.psi.degreecourse.translator;

import com.psi.degreecourse.dto.DegreeCourseCreationDto;
import com.psi.degreecourse.dto.DegreeCourseDto;
import com.psi.degreecourse.model.DegreeCourse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DegreeCourseTranslator {

    public static DegreeCourseDto toDto(DegreeCourse entity) {
        return DegreeCourseDto.of(entity.getId(), entity.getName(), entity.getStudyLanguage());
    }

    public static List<DegreeCourseDto> toDto(List<DegreeCourse> entities) {
        return entities.stream().map(DegreeCourseTranslator::toDto).collect(Collectors.toList());
    }

    public static DegreeCourse toEntity(DegreeCourseCreationDto dto) {
        DegreeCourse entity = new DegreeCourse();
        entity.setName(dto.getName());
        entity.setStudyLanguage(dto.getStudyLanguage());

        return entity;
    }
}
