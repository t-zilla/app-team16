package com.psi.resource;

import com.psi.handler.SubjectHandler;
import com.psi.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.text.MessageFormat.format;

@Slf4j
@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectResource extends AbstractResource {

    private final SubjectHandler subjectHandler;

    @GetMapping
    public List<SubjectDto> getSubjects() {
        log.debug(format("{0} requested list of subjects"), getCurrentUsername());

        return subjectHandler.getSubjects();
    }

}
