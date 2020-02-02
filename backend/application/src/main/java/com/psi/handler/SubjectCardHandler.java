package com.psi.handler;

import com.psi.subjectcard.dto.SubjectCardCreationDto;
import com.psi.subjectcard.dto.SubjectCardDto;
import com.psi.subjectcard.repository.SubjectCardSpecification;
import com.psi.subjectcard.service.SubjectCardService;
import com.psi.subjectcard.translator.SubjectCardTranslator;
import lombok.RequiredArgsConstructor;
import org.javers.core.diff.Change;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectCardHandler {

    private final SubjectCardService service;

    public List<SubjectCardDto> getSubjectCards(Long subjectId) {
        return SubjectCardTranslator.toDto(service.getSubjectCards(new SubjectCardSpecification(subjectId)));
    }

    public SubjectCardDto updateSubjectCard(Long id, SubjectCardCreationDto dto) {
        return SubjectCardTranslator.toDto(service.updateSubjectCard(id, dto));
    }

    public List<Change> getSubjectCardsChanges() {
        return service.getSubjectCardsChanges();
    }

}
