package com.psi.resource;

import com.psi.handler.SyllabusHandler;
import com.psi.syllabus.dto.SyllabusCreationDto;
import com.psi.syllabus.dto.SyllabusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/syllabuses")
@RequiredArgsConstructor
public class SyllabusResource {

    private final SyllabusHandler syllabusHandler;

    @GetMapping
    public List<SyllabusDto> getSyllabuses() {
        return syllabusHandler.getSyllabuses();
    }

    @GetMapping("/{id}")
    public SyllabusDto getSyllabus(@PathVariable("id") Long id) {
        return syllabusHandler.getSyllabus(id);
    }

    @PostMapping
    public SyllabusDto createSyllabus(@RequestBody SyllabusCreationDto dto) {
        return syllabusHandler.createSyllabus(dto);
    }

    @PutMapping("/{id}")
    public SyllabusDto updateSyllabus(@PathVariable("id") Long id, @RequestBody SyllabusCreationDto dto) {
        return syllabusHandler.updateSyllabus(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeSyllabus(@PathVariable("id") Long id) {
        syllabusHandler.removeSyllabus(id);
    }

}
