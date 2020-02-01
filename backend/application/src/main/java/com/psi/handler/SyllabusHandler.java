package com.psi.handler;

import com.psi.syllabus.dto.SyllabusCreationDto;
import com.psi.syllabus.dto.SyllabusDto;
import com.psi.syllabus.service.SyllabusService;
import com.psi.syllabus.translator.SyllabusTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SyllabusHandler {

    private final SyllabusService syllabusService;

    public List<SyllabusDto> getSyllabuses() {
        return SyllabusTranslator.toDto(syllabusService.getSyllabuses());
    }

    public SyllabusDto getSyllabus(Long id) {
        return SyllabusTranslator.toDto(syllabusService.getSyllabus(id));
    }

    public SyllabusDto createSyllabus(SyllabusCreationDto dto) {
        return SyllabusTranslator.toDto(syllabusService.createSyllabus(dto));
    }

    public SyllabusDto updateSyllabus(Long id, SyllabusCreationDto dto) {
        return SyllabusTranslator.toDto(syllabusService.updateSyllabus(id, dto));
    }

    public void removeSyllabus(Long id) {
        syllabusService.removeSyllabus(id);
    }

}
