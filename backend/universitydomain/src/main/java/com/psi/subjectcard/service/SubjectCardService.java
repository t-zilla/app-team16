package com.psi.subjectcard.service;

import com.psi.common.CommonUtil;
import com.psi.subjectcard.dto.SubjectCardCreationDto;
import com.psi.subjectcard.model.SubjectCard;
import com.psi.subjectcard.repository.SubjectCardRepository;
import lombok.RequiredArgsConstructor;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectCardService {

    private final SubjectCardRepository repository;
    private final Javers javers;

    public List<SubjectCard> getSubjectCards() {
        return repository.findAll();
    }

    public SubjectCard getSubjectCard(Long id) {
        return repository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, SubjectCard.class));
    }

    @Transactional
    public SubjectCard updateSubjectCard(Long id, SubjectCardCreationDto dto) {
        SubjectCard subjectCard = getSubjectCard(id);
        subjectCard.setObjectives(dto.getObjectives());
        subjectCard.setEntryRequirements(dto.getEntryRequirements());
        subjectCard.setTeachingTools(dto.getTeachingTools());
        subjectCard.setBasicLiterature(dto.getBasicLiterature());
        subjectCard.setSupplementaryLiterature(dto.getSupplementaryLiterature());

        return repository.save(subjectCard);
    }

    public List<Change> getSubjectCardsChanges() {
        return javers.findChanges(QueryBuilder.byClass(SubjectCard.class).build());
    }

}
