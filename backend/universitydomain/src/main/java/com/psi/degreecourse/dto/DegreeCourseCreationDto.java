package com.psi.degreecourse.dto;

import com.psi.degreecourse.model.StudyLanguage;
import lombok.Getter;

@Getter
public class DegreeCourseCreationDto {

    private String name;
    private StudyLanguage studyLanguage;

}
