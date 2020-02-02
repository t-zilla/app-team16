package com.psi.learningoutcome.repository;

import com.psi.learningoutcome.model.DegreeCourseLearningOutcome;
import com.psi.syllabus.model.Syllabus;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DegreeCourseLearningOutcomeSpecification implements Specification<DegreeCourseLearningOutcome> {

    private Long syllabusId;

    public DegreeCourseLearningOutcomeSpecification(Long syllabusId) {
        super();
        this.syllabusId = syllabusId;
    }

    @Override
    public Predicate toPredicate(Root<DegreeCourseLearningOutcome> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (syllabusId != null) {
            Join<DegreeCourseLearningOutcome, Syllabus> syllabusJoin = root.join("syllabus");
            predicate = criteriaBuilder.equal(syllabusJoin.get("id"), syllabusId);
        }

        return predicate;
    }
}
