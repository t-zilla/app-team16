package com.psi.programcontent.dto;

import com.psi.course.model.CourseForm;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProgramContentDto {

    private Long id;
    private Integer lp;
    private CourseForm courseForm;
    private String content;
    private Integer hoursAmount;
}
