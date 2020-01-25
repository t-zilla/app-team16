package com.psi.degreecourse.dto;

import com.psi.degreecourse.model.StudyLanguage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class DegreeCourseDto {

    private Long id;
    private String name;
    private StudyLanguage studyLanguage;
}
