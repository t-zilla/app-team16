package com.psi.handler;

import com.psi.subject.dto.SubjectDto;
import com.psi.subject.repository.SubjectSpecification;
import com.psi.subject.service.SubjectService;
import com.psi.subject.translator.SubjectTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectHandler {

    private final SubjectService subjectService;

    public List<SubjectDto> getSubjects(Long termId) {
        return SubjectTranslator.toDto(subjectService.geSubjects(new SubjectSpecification(termId)));
    }

    public SubjectDto getSubject(Long id) {
        return SubjectTranslator.toDto(subjectService.getSubject(id));
    }

    public SubjectDto assignResearcherToSubject(Long subjectId, Long researcherId) {
        return SubjectTranslator.toDto(subjectService.assignResearcherToSubject(subjectId, researcherId));
    }
}
