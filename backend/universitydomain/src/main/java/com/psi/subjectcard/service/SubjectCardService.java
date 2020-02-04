package com.psi.subjectcard.service;

import com.psi.common.CommonUtil;
import com.psi.subject.model.Subject;
import com.psi.subject.service.SubjectService;
import com.psi.subjectcard.dto.SubjectCardCreationDto;
import com.psi.subjectcard.model.SubjectCard;
import com.psi.subjectcard.repository.SubjectCardRepository;
import lombok.RequiredArgsConstructor;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectCardService {

    private final SubjectCardRepository subjectCardRepository;
    private final SubjectService subjectService;
    private final Javers javers;

    public List<SubjectCard> getSubjectCards(Specification<SubjectCard> specification) {
        return subjectCardRepository.findAll(specification);
    }

    public SubjectCard getSubjectCard(Long id) {
        return subjectCardRepository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, SubjectCard.class));
    }

    @Transactional
    public SubjectCard createSubjectCard(SubjectCardCreationDto dto) {
        Subject subject = subjectService.getSubject(dto.getSubjectId());
        SubjectCard subjectCard = SubjectCard.builder()
                .objectives(dto.getObjectives())
                .basicLiterature(dto.getBasicLiterature())
                .entryRequirements(dto.getEntryRequirements())
                .supplementaryLiterature(dto.getSupplementaryLiterature())
                .basicLiterature(dto.getBasicLiterature())
                .subject(subject)
                .build();

        return subjectCardRepository.save(subjectCard);
    }

    @Transactional
    public SubjectCard updateSubjectCard(Long id, SubjectCardCreationDto dto) {
        Subject subject = subjectService.getSubject(dto.getSubjectId());
        SubjectCard subjectCard = getSubjectCard(id);
        subjectCard.setObjectives(dto.getObjectives());
        subjectCard.setEntryRequirements(dto.getEntryRequirements());
        subjectCard.setTeachingTools(dto.getTeachingTools());
        subjectCard.setBasicLiterature(dto.getBasicLiterature());
        subjectCard.setSupplementaryLiterature(dto.getSupplementaryLiterature());
        subjectCard.setSubject(subject);

        return subjectCardRepository.save(subjectCard);
    }

    @Transactional
    public void removeSubjectCard(Long id) {
        SubjectCard subjectCard = getSubjectCard(id);
        subjectCardRepository.delete(subjectCard);
    }

    public List<Change> getSubjectCardsChanges() {
        return javers.findChanges(QueryBuilder.byClass(SubjectCard.class).build());
    }

}
