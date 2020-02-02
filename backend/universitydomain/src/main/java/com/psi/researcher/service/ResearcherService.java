package com.psi.researcher.service;

import com.psi.common.CommonUtil;
import com.psi.researcher.model.Researcher;
import com.psi.researcher.repository.ResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResearcherService {

    private final ResearcherRepository researcherRepository;

    public List<Researcher> getResearchers() {
        return researcherRepository.findAll();
    }

    public Researcher getResearcher(Long id) {
        return researcherRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Researcher.class));
    }
}
