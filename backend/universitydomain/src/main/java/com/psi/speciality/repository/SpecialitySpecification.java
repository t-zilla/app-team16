package com.psi.speciality.repository;

import com.psi.degreecourse.model.DegreeCourse;
import com.psi.speciality.model.Speciality;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SpecialitySpecification implements Specification<Speciality> {

    private Long degreeCourseId;

    public SpecialitySpecification(Long degreeCourseId) {
        this.degreeCourseId = degreeCourseId;
    }

    @Override
    public Predicate toPredicate(Root<Speciality> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if(degreeCourseId != null) {
            Join<Speciality, DegreeCourse> degreeJoin = root.join("degreeCourse");
            predicate = criteriaBuilder.equal(degreeJoin.get("id"), degreeCourseId);
        }

        return predicate;
    }
}
