package com.psi.subjectcard.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SubjectCardDto {

    private Long id;
    private List<String> objectives;
    private List<String> entryRequirements;
    private List<String> teachingTools;
    private List<String> basicLiterature;
    private List<String> supplementaryLiterature;
}
