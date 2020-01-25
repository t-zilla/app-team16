package com.psi.resource;

import com.psi.handler.SpecialityHandler;
import com.psi.speciality.dto.SpecialityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/specialities")
@RequiredArgsConstructor
public class SpecialityResource {

    private final SpecialityHandler handler;

    @GetMapping
    public List<SpecialityDto> getSpecialities() {
        return handler.getSpecialities();
    }

    @GetMapping("/{id}")
    public SpecialityDto getSpeciality(@PathVariable("id") Long id) {
        return handler.getSpeciality(id);
    }
}
