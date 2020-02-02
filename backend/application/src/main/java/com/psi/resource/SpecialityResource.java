package com.psi.resource;

import com.psi.handler.SpecialityHandler;
import com.psi.speciality.dto.SpecialityCreationDto;
import com.psi.speciality.dto.SpecialityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/specialities")
@RequiredArgsConstructor
public class SpecialityResource implements RestResource {

    private final SpecialityHandler specialityHandler;

    @GetMapping
    public List<SpecialityDto> getSpecialities(@RequestParam(value = "degreeCourseId", required = false) Long degreeCourseId) {
        return specialityHandler.getSpecialities(degreeCourseId);
    }

    @GetMapping("/{id}")
    public SpecialityDto getSpeciality(@PathVariable("id") Long id) {
        return specialityHandler.getSpeciality(id);
    }

    @PostMapping
    public SpecialityDto createSpeciality(@RequestBody SpecialityCreationDto dto) {
        return specialityHandler.createSpeciality(dto);
    }

    @PutMapping("/{id}")
    public SpecialityDto updateSpeciality(@PathVariable("id") Long id, @RequestBody SpecialityCreationDto dto) {
        return specialityHandler.updateSpeciality(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeSpeciality(@PathVariable("id") Long id) {
        specialityHandler.removeSpeciality(id);
    }
}
