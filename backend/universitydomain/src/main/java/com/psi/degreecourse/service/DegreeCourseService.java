package com.psi.degreecourse.service;

import com.psi.common.CommonUtil;
import com.psi.degreecourse.dto.DegreeCourseCreationDto;
import com.psi.degreecourse.model.DegreeCourse;
import com.psi.degreecourse.repository.DegreeCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DegreeCourseService {

    private final DegreeCourseRepository repository;

    public List<DegreeCourse> getDegreeCourses() {
        return repository.findAll();
    }

    public DegreeCourse getDegreeCourse(Long id) {
        return repository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, DegreeCourse.class));
    }

    public DegreeCourse createDegreeCourse(DegreeCourse entity) {
        return repository.save(entity);
    }

    @Transactional
    public DegreeCourse updateDegreeCourse(Long id, DegreeCourseCreationDto dto) {
        DegreeCourse entity = getDegreeCourse(id);
        entity.setName(dto.getName());
        entity.setStudyLanguage(dto.getStudyLanguage());

        return repository.save(entity);
    }

    @Transactional
    public void removeDegreeCourse(Long id) {
        DegreeCourse entity = getDegreeCourse(id);
        repository.delete(entity);
    }

}
