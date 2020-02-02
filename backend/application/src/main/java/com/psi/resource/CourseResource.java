package com.psi.resource;

import com.psi.course.dto.CourseDto;
import com.psi.handler.CourseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseResource implements RestResource {

    private final CourseHandler courseHandler;

    @GetMapping
    public List<CourseDto> getCourses(@RequestParam(value = "subjectId", required = false) Long subjectId) {
        return courseHandler.getCourses(subjectId);
    }

}
