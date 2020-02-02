package com.psi.subjecttoterm.repository;

import com.psi.subjecttoterm.model.SubjectToTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectToTermRepository extends JpaRepository<SubjectToTerm, Long> {

    Optional<SubjectToTerm> findBySubjectIdAndTermId(Long subjectId, Long TermId);
}
