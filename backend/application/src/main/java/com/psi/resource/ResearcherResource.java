package com.psi.resource;

import com.psi.handler.ResearcherHandler;
import com.psi.researcher.dto.ResearcherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/researchers")
@RequiredArgsConstructor
public class ResearcherResource {

    private final ResearcherHandler researcherHandler;

    @GetMapping
    public List<ResearcherDto> getResearchers() {
        return researcherHandler.getResearchers();
    }

    @GetMapping("/{id}")
    public ResearcherDto getResearcher(@PathVariable("id") Long id) {
        return researcherHandler.getResearcher(id);
    }
}
