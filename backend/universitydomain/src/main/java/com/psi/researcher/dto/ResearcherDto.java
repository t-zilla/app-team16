package com.psi.researcher.dto;

import com.psi.researcher.model.AcademicDegree;
import com.psi.researcher.model.Position;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResearcherDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
    private AcademicDegree academicDegree;
}
