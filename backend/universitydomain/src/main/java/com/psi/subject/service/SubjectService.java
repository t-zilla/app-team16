package com.psi.subject.service;

import com.psi.common.CommonUtil;
import com.psi.researcher.model.Researcher;
import com.psi.researcher.service.ResearcherService;
import com.psi.subject.model.Subject;
import com.psi.subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ResearcherService researcherService;

    public List<Subject> geSubjects(Specification<Subject> specification) {
        return subjectRepository.findAll(specification);
    }

    public Subject getSubject(Long id) {
        return subjectRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Subject.class));
    }

    @Transactional
    public Subject assignResearcherToSubject(Long subjectId, Long researcherId) {
        Researcher researcher = researcherService.getResearcher(researcherId);
        Subject subject = getSubject(subjectId);
        subject.setResearcher(researcher);

        return subject;
    }
}
