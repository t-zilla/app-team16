package com.psi.speciality.service;

import com.psi.common.CommonUtil;
import com.psi.degreecourse.model.DegreeCourse;
import com.psi.degreecourse.service.DegreeCourseService;
import com.psi.speciality.dto.SpecialityCreationDto;
import com.psi.speciality.model.Speciality;
import com.psi.speciality.repository.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityService {

    private final SpecialityRepository specialityRepository;
    private final DegreeCourseService degreeCourseService;

    public List<Speciality> getSpecialities(Specification<Speciality> specification) {
        return specialityRepository.findAll(specification);
    }

    public Speciality getSpeciality(Long id) {
        return specialityRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Speciality.class));
    }

    @Transactional
    public Speciality createSpeciality(SpecialityCreationDto dto) {
        DegreeCourse degreeCourse = degreeCourseService.getDegreeCourse(dto.getDegreeCourseId());
        Speciality speciality = Speciality.builder()
                .name(dto.getName())
                .degreeCourse(degreeCourse)
                .build();

        return specialityRepository.save(speciality);
    }

    @Transactional
    public Speciality updateSpeciality(Long id, SpecialityCreationDto dto) {
        Speciality speciality = getSpeciality(id);
        DegreeCourse degreeCourse = degreeCourseService.getDegreeCourse(dto.getDegreeCourseId());
        speciality.setName(dto.getName());
        speciality.setDegreeCourse(degreeCourse);

        return specialityRepository.save(speciality);
    }

    @Transactional
    public void removeSpeciality(Long id) {
        Speciality speciality = getSpeciality(id);
        specialityRepository.delete(speciality);
    }

}
