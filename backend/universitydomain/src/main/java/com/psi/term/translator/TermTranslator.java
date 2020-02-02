package com.psi.term.translator;

import com.psi.term.dto.TermDto;
import com.psi.term.model.Term;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TermTranslator {

    public TermDto toDto(Term entity) {
        return TermDto.builder()
                .id(entity.getId())
                .allowedDeficit(entity.getAllowedDeficit())
                .cnpsSum(entity.getCnpsSum())
                .ectsSum(entity.getEctsSum())
                .zzuSum(entity.getZzuSum())
                .build();
    }

    public List<TermDto> toDto(List<Term> entities) {
        return entities.stream().map(TermTranslator::toDto).collect(Collectors.toList());
    }
}
