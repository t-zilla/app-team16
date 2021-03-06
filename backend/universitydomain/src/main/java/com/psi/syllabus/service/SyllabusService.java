package com.psi.syllabus.service;

import com.psi.common.CommonUtil;
import com.psi.degreecourse.model.DegreeCourse;
import com.psi.degreecourse.repository.DegreeCourseRepository;
import com.psi.speciality.model.Speciality;
import com.psi.speciality.repository.SpecialityRepository;
import com.psi.syllabus.dto.SyllabusCreationDto;
import com.psi.syllabus.model.Syllabus;
import com.psi.syllabus.repository.SyllabusRepository;
import lombok.RequiredArgsConstructor;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SyllabusService {

    private final SyllabusRepository syllabusRepository;
    private final SpecialityRepository specialityRepository;
    private final DegreeCourseRepository degreeCourseRepository;
    private final Javers javers;

    public List<Syllabus> getSyllabuses(Specification<Syllabus> specification) {
        return syllabusRepository.findAll(specification);
    }

    public Syllabus getSyllabus(Long id) {
        return syllabusRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Syllabus.class));
    }

    public Syllabus createSyllabus(SyllabusCreationDto dto) {
        DegreeCourse degreeCourse = dto.getDegreeCurseId() != null ?
                degreeCourseRepository.findById(dto.getDegreeCurseId()).orElse(null) :
                null;
        Speciality speciality = dto.getSpecialityId() != null ?
                specialityRepository.findById(dto.getSpecialityId()).orElse(null) :
                null;
        Syllabus syllabus = Syllabus.builder()
                .name(dto.getName())
                .studyDegree(dto.getStudyDegree())
                .studyForm(dto.getStudyForm())
                .learningProfile(dto.getLearningProfile())
                .termAmount(dto.getTermAmount())
                .entryRequirements(dto.getEntryRequirements())
                .professionalTitle(dto.getProfessionalTitle())
                .graduationForm(dto.getGraduationForm())
                .graduateSilhouette(dto.getGraduateSilhouette())
                .cnpsMultiplier(dto.getCnpsMultiplier())
                .extendedTermAmount(dto.getExtendedTermAmount())
                .examIssues(dto.getExamIssues())
                .degreeCourse(degreeCourse)
                .speciality(speciality)
                .build();

        return syllabusRepository.save(syllabus);
    }

    @Transactional
    public Syllabus updateSyllabus(Long id, SyllabusCreationDto dto) {
        DegreeCourse degreeCourse = dto.getDegreeCurseId() != null ?
                degreeCourseRepository.findById(dto.getDegreeCurseId()).orElse(null) :
                null;
        Speciality speciality = dto.getSpecialityId() != null ?
                specialityRepository.findById(dto.getSpecialityId()).orElse(null) :
                null;
        Syllabus syllabus = getSyllabus(id);
        syllabus.setName(dto.getName());
        syllabus.setStudyDegree(dto.getStudyDegree());
        syllabus.setStudyForm(dto.getStudyForm());
        syllabus.setLearningProfile(dto.getLearningProfile());
        syllabus.setTermAmount(dto.getTermAmount());
        syllabus.setEntryRequirements(dto.getEntryRequirements());
        syllabus.setProfessionalTitle(dto.getProfessionalTitle());
        syllabus.setGraduationForm(dto.getGraduationForm());
        syllabus.setGraduateSilhouette(dto.getGraduateSilhouette());
        syllabus.setCnpsMultiplier(dto.getCnpsMultiplier());
        syllabus.setExtendedTermAmount(dto.getExtendedTermAmount());
        syllabus.setExamIssues(dto.getExamIssues());
        syllabus.setDegreeCourse(degreeCourse);
        syllabus.setSpeciality(speciality);

        return syllabusRepository.save(syllabus);
    }

    @Transactional
    public void removeSyllabus(Long id) {
        Syllabus syllabus = getSyllabus(id);
        syllabusRepository.delete(syllabus);
    }

    public List<Change> getSyllabusesChanges() {
        return javers.findChanges(QueryBuilder.byClass(Syllabus.class).build());
    }
}
