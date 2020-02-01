package com.psi.course.dto;

import com.psi.course.model.CourseForm;
import com.psi.course.model.CreditForm;
import com.psi.course.model.LanguageLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourseDto {

    private Long id;
    private String code;
    private Integer zzu;
    private Integer cnps;
    private Integer ects;
    private CreditForm creditForm;
    private Boolean finalCourse;
    private CourseForm courseForm;
    private Integer hoursWeekly;
    private LanguageLevel languageLevel;
}
