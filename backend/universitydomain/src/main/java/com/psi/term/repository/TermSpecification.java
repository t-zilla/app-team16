package com.psi.term.repository;

import com.psi.syllabus.model.Syllabus;
import com.psi.term.model.Term;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TermSpecification implements Specification<Term> {

    private Long syllabusId;

    public TermSpecification(Long syllabusId) {
        super();
        this.syllabusId = syllabusId;
    }

    @Override
    public Predicate toPredicate(Root<Term> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (syllabusId != null) {
            Join<Term, Syllabus> syllabusJoin = root.join("syllabus");
            predicate = criteriaBuilder.equal(syllabusJoin.get("id"), syllabusId);
        }

        return predicate;
    }
}
