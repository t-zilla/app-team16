package com.psi.handler;

import com.psi.subject.dto.SubjectDto;
import com.psi.subject.service.SubjectService;
import com.psi.subject.translator.SubjectTranslator;
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

}
