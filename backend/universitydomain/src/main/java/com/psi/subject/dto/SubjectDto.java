package com.psi.subject.dto;

import com.psi.subject.model.SubjectLearningArea;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectDto {

    private Long id;
    private String code;
    private String polishName;
    private String englishName;
    private SubjectLearningArea subjectLearningArea;
    private int ectsSum;
    private int cnpsSum;
    private int zzuSum;
}
