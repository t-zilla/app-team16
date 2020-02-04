package com.psi.handler;

import com.psi.syllabus.dto.SyllabusCreationDto;
import com.psi.syllabus.dto.SyllabusDto;
import com.psi.syllabus.repository.SyllabusSpecification;
import com.psi.syllabus.service.SyllabusService;
import com.psi.syllabus.translator.SyllabusTranslator;
import lombok.RequiredArgsConstructor;
import org.javers.core.diff.Change;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SyllabusHandler {

    private final SyllabusService syllabusService;

    public List<SyllabusDto> getSyllabuses(Long degreeCourseId, Long specialityId) {
        return SyllabusTranslator.toDto(syllabusService.getSyllabuses(new SyllabusSpecification(degreeCourseId, specialityId)));
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

    public List<Change> getSyllabusesChanges() {
        return syllabusService.getSyllabusesChanges();
    }
}
