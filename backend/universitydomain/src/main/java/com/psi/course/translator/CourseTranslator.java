package com.psi.course.translator;

import com.psi.course.dto.CourseDto;
import com.psi.course.model.Course;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CourseTranslator {

    public CourseDto toDto(Course entity) {
        return CourseDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .zzu(entity.getZzu())
                .cnps(entity.getCnps())
                .ects(entity.getEcts())
                .creditForm(entity.getCreditForm())
                .finalCourse(entity.getFinalCourse())
                .courseForm(entity.getCourseForm())
                .hoursWeekly(entity.getHoursWeekly())
                .languageLevel(entity.getLanguageLevel())
                .build();
    }

    public List<CourseDto> toDto(List<Course> entities) {
        return entities.stream().map(CourseTranslator::toDto).collect(Collectors.toList());
    }
}
