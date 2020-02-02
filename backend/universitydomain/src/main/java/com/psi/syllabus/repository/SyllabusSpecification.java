package com.psi.syllabus.repository;

import com.psi.degreecourse.model.DegreeCourse;
import com.psi.speciality.model.Speciality;
import com.psi.syllabus.model.Syllabus;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SyllabusSpecification implements Specification<Syllabus> {

    private Long degreeCourseId;
    private Long specialityId;

    public SyllabusSpecification(Long degreeCourseId, Long specialityId) {
        super();
        this.degreeCourseId = degreeCourseId;
        this.specialityId = specialityId;
    }

    @Override
    public Predicate toPredicate(Root<Syllabus> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (degreeCourseId != null) {
            Join<Syllabus, DegreeCourse> degreeJoin = root.join("degreeCourse");
            predicates.add(criteriaBuilder.equal(degreeJoin.get("id"), degreeCourseId));
        }

        if (specialityId != null) {
            Join<Syllabus, Speciality> specialityJoin = root.join("speciality");
            predicates.add(criteriaBuilder.equal(specialityJoin.get("id"), specialityId));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
