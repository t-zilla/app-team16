package com.psi.subject.repository;

import com.psi.subject.model.Subject;
import com.psi.subjecttoterm.model.SubjectToTerm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SubjectSpecification implements Specification<Subject> {

    private Long termId;

    public SubjectSpecification(Long termId) {
        this.termId = termId;
    }

    @Override
    public Predicate toPredicate(Root<Subject> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (termId != null) {
            Join<Subject, SubjectToTerm> termJoin = root.join("subjectToTerms").join("term");
            predicate = criteriaBuilder.equal(termJoin.get("id"), termId);
        }

        return predicate;
    }
}
