package com.psi.handler;

import com.psi.term.dto.TermCreationDto;
import com.psi.term.dto.TermDto;
import com.psi.term.repository.TermSpecification;
import com.psi.term.service.TermService;
import com.psi.term.translator.TermTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TermHandler {

    private final TermService termService;

    public List<TermDto> getTerms(Long syllabusId) {
        return TermTranslator.toDto(termService.getTerms(new TermSpecification(syllabusId)));
    }

    public TermDto getTerm(Long id) {
        return TermTranslator.toDto(termService.getTerm(id));
    }

    public TermDto createTerm(TermCreationDto dto) {
        return TermTranslator.toDto(termService.createTerm(dto));
    }

    public void removeTerm(Long id) {
        termService.removeTerm(id);
    }
}
