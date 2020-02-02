package com.psi.term.service;

import com.psi.common.CommonUtil;
import com.psi.syllabus.model.Syllabus;
import com.psi.syllabus.service.SyllabusService;
import com.psi.term.dto.TermCreationDto;
import com.psi.term.model.Term;
import com.psi.term.repository.TermRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TermService {

    private final TermRepository termRepository;
    private final SyllabusService syllabusService;

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

    public void removeTerm(Long id) {
        Term term = getTerm(id);
        termRepository.delete(term);
    }
}
