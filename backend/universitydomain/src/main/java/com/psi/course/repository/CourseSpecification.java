package com.psi.course.repository;

import com.psi.course.model.Course;
import com.psi.subject.model.Subject;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CourseSpecification implements Specification<Course> {

    private Long subjectId;

    public CourseSpecification(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (subjectId != null) {
            Join<Course, Subject> subjectJoin = root.join("subject");
            predicate = criteriaBuilder.equal(subjectJoin.get("id"), subjectId);
        }

        return predicate;
    }
}
