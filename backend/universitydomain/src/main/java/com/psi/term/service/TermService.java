package com.psi.term.service;

import com.psi.common.CommonUtil;
import com.psi.subject.model.Subject;
import com.psi.subject.service.SubjectService;
import com.psi.subjecttoterm.dto.SubjectToTermCreationDto;
import com.psi.subjecttoterm.model.SubjectToTerm;
import com.psi.subjecttoterm.repository.SubjectToTermRepository;
import com.psi.syllabus.model.Syllabus;
import com.psi.syllabus.service.SyllabusService;
import com.psi.term.dto.TermCreationDto;
import com.psi.term.model.Term;
import com.psi.term.repository.TermRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TermService {

    private final TermRepository termRepository;
    private final SubjectToTermRepository subjectToTermRepository;
    private final SyllabusService syllabusService;
    private final SubjectService subjectService;

    public List<Term> getTerms(Specification<Term> specification) {
        return termRepository.findAll(specification);
    }

    public Term getTerm(Long id) {
        return termRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Term.class));
    }

    public Term createTerm(TermCreationDto dto) {
        Syllabus syllabus = syllabusService.getSyllabus(dto.getSyllabusId());
        Term term = Term.builder()
                .allowedDeficit(dto.getAllowedDeficit())
                .syllabus(syllabus)
                .build();

        return termRepository.save(term);
    }

    @Transactional
    public Term updateTerm(Long id, TermCreationDto dto) {
        Term term = getTerm(id);
        Syllabus syllabus = syllabusService.getSyllabus(dto.getSyllabusId());
        term.setAllowedDeficit(dto.getAllowedDeficit());
        term.setSyllabus(syllabus);

        return termRepository.save(term);
    }

    @Transactional
    public void removeTerm(Long id) {
        Term term = getTerm(id);
        termRepository.delete(term);
    }

    @Transactional
    public void addSubjectToTerm(Long termId, SubjectToTermCreationDto dto) {
        Term term = getTerm(termId);
        Subject subject = subjectService.getSubject(dto.getSubjectId());
        if (!subjectToTermRepository.findBySubjectIdAndTermId(dto.getSubjectId(), termId).isPresent()) {
            SubjectToTerm subjectToTerm = SubjectToTerm.builder()
                    .subject(subject)
                    .term(term)
                    .obligatory(dto.getObligatory())
                    .build();
            subjectToTermRepository.save(subjectToTerm);
        }
    }
}
