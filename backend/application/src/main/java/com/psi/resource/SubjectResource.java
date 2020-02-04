package com.psi.resource;

import com.psi.handler.SubjectHandler;
import com.psi.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<SubjectDto> getSubjects(@RequestParam(value = "termId", required = false) Long termId) {
        log.debug(format("{0} requested list of Subjects"), getCurrentUsername());

        return subjectHandler.getSubjects(termId);
    }

    @GetMapping("/{id}")
    public SubjectDto getSubject(@PathVariable("id") Long id) {
        log.debug(format("{0} requested Subject with id: {1}"), getCurrentUsername(), id);

        return subjectHandler.getSubject(id);
    }

    @PostMapping("/{id}/researcher")
    public SubjectDto assignResearcherToSubject(@PathVariable("id") Long subjectId,
                                                @RequestBody Long researcherId) {
        log.info(format("{0} requested Subject assignment with id: {1} and Researcher id: {2}"),
                getCurrentUsername(), subjectId, researcherId);

        return subjectHandler.assignResearcherToSubject(subjectId, researcherId);
    }

}
