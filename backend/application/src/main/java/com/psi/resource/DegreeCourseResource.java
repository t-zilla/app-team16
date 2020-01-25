package com.psi.resource;

import com.psi.degreecourse.dto.DegreeCourseCreationDto;
import com.psi.degreecourse.dto.DegreeCourseDto;
import com.psi.handler.DegreeCourseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/degree-courses")
public class DegreeCourseResource {

    private final DegreeCourseHandler handler;

    @GetMapping
    public List<DegreeCourseDto> getDegreeCourses() {
        log.debug("Requested get Degree Courses");

        return handler.getDegreeCourses();
    }

    @GetMapping("/{id}")
    public DegreeCourseDto getDegreeCourse(@PathVariable("id") Long id) {
        log.debug("Requested get Degree Course");

        return handler.getDegreeCourse(id);
    }

    @PostMapping
    public DegreeCourseDto createDegreeCourse(@RequestBody DegreeCourseCreationDto dto) {
        log.info("Requested creation of Degree Course");

        return handler.createDegreeCourse(dto);
    }

    @PutMapping("/{id}")
    public DegreeCourseDto updateDegreeCourse(@PathVariable("id") Long id,
                                              @RequestBody DegreeCourseCreationDto dto) {
        log.info("Requested update of Degree Course");

        return handler.updateDegreeCourse(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeDegreeCourse(@PathVariable("id") Long id) {
        log.info("Requested removal of Degree Course");

        handler.removeDegreeCourse(id);
    }

}
