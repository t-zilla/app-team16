package com.psi.handler;

import com.psi.speciality.dto.SpecialityDto;
import com.psi.speciality.service.SpecialityService;
import com.psi.speciality.translator.SpecialityTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpecialityHandler {

    private final SpecialityService service;

    public List<SpecialityDto> getSpecialities() {
        return SpecialityTranslator.toDto(service.getSpecialities());
    }

    public SpecialityDto getSpeciality(Long id) {
        return SpecialityTranslator.toDto(service.getSpecialities(id));
    }
}
