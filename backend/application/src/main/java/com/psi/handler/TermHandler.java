package com.psi.handler;

import com.psi.term.dto.TermDto;
import com.psi.term.service.TermService;
import com.psi.term.translator.TermTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TermHandler {

    private final TermService termService;

    public List<TermDto> getTerms() {
        return TermTranslator.toDto(termService.getTerms());
    }

    public TermDto getTerm(Long id) {
        return TermTranslator.toDto(termService.getTerm(id));
    }
}
