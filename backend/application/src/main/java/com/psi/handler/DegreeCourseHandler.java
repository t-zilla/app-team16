package com.psi.handler;

import com.psi.degreecourse.dto.DegreeCourseCreationDto;
import com.psi.degreecourse.dto.DegreeCourseDto;
import com.psi.degreecourse.service.DegreeCourseService;
import com.psi.degreecourse.translator.DegreeCourseTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DegreeCourseHandler {

    private final DegreeCourseService service;

    public List<DegreeCourseDto> getDegreeCourses() {
        return DegreeCourseTranslator.toDto(service.getDegreeCourses());
    }

    public DegreeCourseDto getDegreeCourse(Long id) {
        return DegreeCourseTranslator.toDto(service.getDegreeCourse(id));
    }

    public DegreeCourseDto createDegreeCourse(DegreeCourseCreationDto dto) {
        return DegreeCourseTranslator.toDto(service.createDegreeCourse(DegreeCourseTranslator.toEntity(dto)));
    }

    public DegreeCourseDto updateDegreeCourse(Long id, DegreeCourseCreationDto dto) {
        return DegreeCourseTranslator.toDto(service.updateDegreeCourse(id, dto));
    }

    public void removeDegreeCourse(Long id) {
        service.removeDegreeCourse(id);
    }
}
