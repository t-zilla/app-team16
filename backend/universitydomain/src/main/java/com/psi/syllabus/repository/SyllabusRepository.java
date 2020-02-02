package com.psi.syllabus.repository;

import com.psi.syllabus.model.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Long>, JpaSpecificationExecutor<Syllabus> {
}
