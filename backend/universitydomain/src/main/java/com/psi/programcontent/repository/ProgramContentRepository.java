package com.psi.programcontent.repository;

import com.psi.programcontent.model.ProgramContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramContentRepository extends JpaRepository<ProgramContent, Long> {
}
