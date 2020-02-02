package com.psi.syllabus.dto;

import com.psi.syllabus.model.LearningProfile;
import com.psi.syllabus.model.ProfessionalTitle;
import com.psi.syllabus.model.StudyDegree;
import com.psi.syllabus.model.StudyForm;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SyllabusDto {

    private Long id;
    private String name;
    private StudyDegree studyDegree;
    private StudyForm studyForm;
    private LearningProfile learningProfile;
    private Integer termAmount;
    private String entryRequirements;
    private ProfessionalTitle professionalTitle;
    private String graduationForm;
    private String graduateSilhouette;
    private Integer cnpsMultiplier;
    private Boolean extendedTermAmount;
    private List<String> examIssues;
    private Integer cnpsSum;
    private Integer ectsSum;
    private Integer zzuSum;
}
