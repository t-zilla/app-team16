package com.psi.subject.service;

import com.psi.common.CommonUtil;
import com.psi.subject.model.Subject;
import com.psi.subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;

    public List<Subject> geSubjects() {
        return repository.findAll();
    }

    public Subject getSubject(Long id) {
        return repository.findById(id).orElseThrow(CommonUtil.noEntityFoundById(id, Subject.class));
    }
}
