package com.psi.handler;

import com.psi.speciality.dto.SpecialityCreationDto;
import com.psi.speciality.dto.SpecialityDto;
import com.psi.speciality.service.SpecialityService;
import com.psi.speciality.translator.SpecialityTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpecialityHandler {

    private final SpecialityService specialityService;

    public List<SpecialityDto> getSpecialities() {
        return SpecialityTranslator.toDto(specialityService.getSpeciality());
    }

    public SpecialityDto getSpeciality(Long id) {
        return SpecialityTranslator.toDto(specialityService.getSpeciality(id));
    }

    public SpecialityDto createSpeciality(SpecialityCreationDto dto) {
        return SpecialityTranslator.toDto(specialityService.createSpeciality(dto));
    }

    public SpecialityDto updateSpeciality(Long id, SpecialityCreationDto dto) {
        return SpecialityTranslator.toDto(specialityService.updateSpeciality(id, dto));
    }

    public void removeSpeciality(Long id) {
        specialityService.removeSpeciality(id);
    }
}
