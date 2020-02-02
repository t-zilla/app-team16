package com.psi.term.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TermDto {

    private Long id;
    private Integer allowedDeficit;
    private int ectsSum;
    private int zzuSum;
    private int cnpsSum;
}
