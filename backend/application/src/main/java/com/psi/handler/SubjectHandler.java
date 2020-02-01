package com.psi.handler;

import com.psi.subject.dto.SubjectDto;
import com.psi.subject.service.SubjectService;
import com.psi.subject.translator.SubjectTranslator;
import com.psi.subjectcard.dto.SubjectCardDto;
import com.psi.subjectcard.translator.SubjectCardTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectHandler {

    private final SubjectService subjectService;

    public List<SubjectDto> getSubjects() {
        return SubjectTranslator.toDto(subjectService.geSubjects());
    }

    public SubjectDto getSubject(Long id) {
        return SubjectTranslator.toDto(subjectService.getSubject(id));
    }

    public SubjectCardDto getSubjectCard(Long id) {
        return SubjectCardTranslator.toDto(subjectService.getSubject(id).getSubjectCard());
    }
}
