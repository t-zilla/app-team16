package com.psi.handler;

import com.psi.course.dto.CourseDto;
import com.psi.course.repository.CourseSpecification;
import com.psi.course.service.CourseService;
import com.psi.course.translator.CourseTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseHandler {

    private final CourseService courseService;

    public List<CourseDto> getCourses(Long subjectId) {
        return CourseTranslator.toDto(courseService.getCourses(new CourseSpecification(subjectId)));
    }
}
