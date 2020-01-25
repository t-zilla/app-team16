package com.psi.degreecourse.repository;

import com.psi.degreecourse.model.DegreeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeCourseRepository extends JpaRepository<DegreeCourse, Long> {
}
