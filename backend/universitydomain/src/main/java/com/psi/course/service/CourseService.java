package com.psi.course.service;

import com.psi.course.model.Course;
import com.psi.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getCourses(Specification<Course> specification) {
        return courseRepository.findAll(specification);
    }
}
