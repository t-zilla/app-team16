package com.psi.speciality.dto;

import com.psi.degreecourse.dto.DegreeCourseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class SpecialityDto {

    private Long id;
    private String name;
}
