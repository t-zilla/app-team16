package com.psi.speciality.service;

import com.psi.common.CommonUtil;
import com.psi.speciality.model.Speciality;
import com.psi.speciality.repository.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityService {

    private final SpecialityRepository repository;

    public List<Speciality> getSpecialities() {
        return repository.findAll();
    }

    public Speciality getSpecialities(Long id) {
        return repository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Speciality.class));
    }

}
