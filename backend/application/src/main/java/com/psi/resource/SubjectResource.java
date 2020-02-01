package com.psi.resource;

import com.psi.handler.SubjectHandler;
import com.psi.subject.dto.SubjectDto;
import com.psi.subjectcard.dto.SubjectCardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.text.MessageFormat.format;

@Slf4j
@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectResource implements RestResource {

    private final SubjectHandler subjectHandler;

    @GetMapping
    public List<SubjectDto> getSubjects() {
        log.debug(format("{0} requested list of Subjects"), getCurrentUsername());

        return subjectHandler.getSubjects();
    }

    @GetMapping("/{id}")
    public SubjectDto getSubject(@PathVariable("id") Long id) {
        log.debug(format("{0} requested  Subject with id: {1}"), getCurrentUsername(), id);

        return subjectHandler.getSubject(id);
    }

    @GetMapping("/{id}/subject-card")
    public SubjectCardDto getSubjectCard(@PathVariable("id") Long id) {
        log.debug(format("{0} requested Subject Card with id: {1}"), getCurrentUsername(), id);

        return subjectHandler.getSubjectCard(id);
    }
}
