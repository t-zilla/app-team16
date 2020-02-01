package com.psi.term.service;

import com.psi.common.CommonUtil;
import com.psi.term.model.Term;
import com.psi.term.repository.TermRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TermService {

    private final TermRepository termRepository;

    public List<Term> getTerms() {
        return termRepository.findAll();
    }

    public Term getTerm(Long id) {
        return termRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Term.class));
    }
}
