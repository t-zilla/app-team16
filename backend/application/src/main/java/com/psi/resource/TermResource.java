package com.psi.resource;

import com.psi.handler.TermHandler;
import com.psi.subjecttoterm.dto.SubjectToTermCreationDto;
import com.psi.term.dto.TermCreationDto;
import com.psi.term.dto.TermDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/terms")
@RequiredArgsConstructor
public class TermResource implements RestResource {

    private final TermHandler termHandler;

    @GetMapping
    public List<TermDto> getTerms(@RequestParam(value = "syllabusId", required = false) Long syllabusId) {
        return termHandler.getTerms(syllabusId);
    }

    @GetMapping("/{id}")
    public TermDto getTerm(@PathVariable("id") Long id) {
        return termHandler.getTerm(id);
    }

    @PostMapping
    public TermDto createTerm(@RequestBody TermCreationDto dto) {
        return termHandler.createTerm(dto);
    }

    @PutMapping("/{id}")
    public TermDto updateTerm(@PathVariable("id") Long id, @RequestBody TermCreationDto dto) {
        return termHandler.updateTerm(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeTerm(@PathVariable("id") Long id) {
        termHandler.removeTerm(id);
    }

    @PostMapping("/{termId}/subjects")
    public void addSubjectToTerm(@PathVariable("termId") Long termId, @RequestBody SubjectToTermCreationDto dto) {
        termHandler.addSubjectToTerm(termId, dto);
    }
}
