package com.psi.handler;

import com.psi.researcher.dto.ResearcherDto;
import com.psi.researcher.service.ResearcherService;
import com.psi.researcher.translator.ResearcherTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResearcherHandler {

    private final ResearcherService researcherService;

    public List<ResearcherDto> getResearchers() {
        return ResearcherTranslator.toDto(researcherService.getResearchers());
    }

    public ResearcherDto getResearcher(Long id) {
        return ResearcherTranslator.toDto(researcherService.getResearcher(id));
    }

}
