package com.psi.subjectcard.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class SubjectCardCreationDto {

    private List<String> objectives;
    private List<String> entryRequirements;
    private List<String> teachingTools;
    private List<String> basicLiterature;
    private List<String> supplementaryLiterature;
    private Long subjectId;
}
