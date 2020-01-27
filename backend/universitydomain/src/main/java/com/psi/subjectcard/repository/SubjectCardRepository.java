package com.psi.subjectcard.repository;

import com.psi.subjectcard.model.SubjectCard;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;

@JaversSpringDataAuditable
public interface SubjectCardRepository extends JpaRepository<SubjectCard, Long> {
}
