package com.psi.subjectcard.repository;

import com.psi.subject.model.Subject;
import com.psi.subjectcard.model.SubjectCard;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SubjectCardSpecification implements Specification<SubjectCard> {

    private Long subjectId;

    public SubjectCardSpecification(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public Predicate toPredicate(Root<SubjectCard> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (subjectId != null) {
            Join<SubjectCard, Subject> subjectJoin = root.join("subject");
            predicate = criteriaBuilder.equal(subjectJoin.get("id"), subjectId);
        }

        return predicate;
    }
}
