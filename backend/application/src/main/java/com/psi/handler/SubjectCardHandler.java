package com.psi.handler;

import com.psi.subjectcard.dto.SubjectCardCreationDto;
import com.psi.subjectcard.dto.SubjectCardDto;
import com.psi.subjectcard.model.SubjectCard;
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

    private final SubjectCardService subjectCardService;

    public List<SubjectCardDto> getSubjectCards(Long subjectId) {
        return SubjectCardTranslator.toDto(subjectCardService.getSubjectCards(new SubjectCardSpecification(subjectId)));
    }

    public SubjectCard getSubjectCard(Long id) {
        return subjectCardService.getSubjectCard(id);
    }

    public SubjectCardDto createSubjectCard(SubjectCardCreationDto dto) {
        return SubjectCardTranslator.toDto(subjectCardService.createSubjectCard(dto));
    }

    public SubjectCardDto updateSubjectCard(Long id, SubjectCardCreationDto dto) {
        return SubjectCardTranslator.toDto(subjectCardService.updateSubjectCard(id, dto));
    }

    public void removeSubjectCard(Long id) {
        subjectCardService.removeSubjectCard(id);
    }

    public List<Change> getSubjectCardsChanges() {
        return subjectCardService.getSubjectCardsChanges();
    }

}
