package com.psi.resource;

import com.psi.handler.TermHandler;
import com.psi.term.dto.TermCreationDto;
import com.psi.term.dto.TermDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/terms")
@RequiredArgsConstructor
public class TermResource implements RestResource {

    private final TermHandler termHandler;

    @GetMapping
    public List<TermDto> getTerms() {
        return termHandler.getTerms();
    }

    @GetMapping("/{id}")
    public TermDto getTerm(@PathVariable("id") Long id) {
        return termHandler.getTerm(id);
    }

    @PostMapping
    public TermDto createTerm(@RequestBody TermCreationDto dto) {
        return termHandler.createTerm(dto);
    }

    @DeleteMapping("/{id}")
    public void removeTerm(@PathVariable("id") Long id) {
        termHandler.removeTerm(id);
    }
}
