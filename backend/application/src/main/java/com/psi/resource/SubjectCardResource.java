package com.psi.resource;

import com.psi.handler.SubjectCardHandler;
import com.psi.subjectcard.dto.SubjectCardCreationDto;
import com.psi.subjectcard.dto.SubjectCardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.diff.Change;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.text.MessageFormat.format;

@Slf4j
@RestController
@RequestMapping("/api/subject-cards")
@RequiredArgsConstructor
public class SubjectCardResource implements RestResource {

    private final SubjectCardHandler subjectCardHandler;

    @GetMapping
    public List<SubjectCardDto> getSubjectCards(@RequestParam(value = "subjectId", required = false) Long subjectId) {
        log.info(format("[{0}] requested Subject Cards list", getCurrentUsername()));

        return subjectCardHandler.getSubjectCards(subjectId);
    }

    @PutMapping("/{id}")
    public SubjectCardDto updateSubjectCard(@PathVariable("id") Long id,
                                            @RequestBody SubjectCardCreationDto dto) {
        return subjectCardHandler.updateSubjectCard(id, dto);
    }

    @GetMapping("/audit")
    public List<Change> getSubjectCardsChanges() {
        return subjectCardHandler.getSubjectCardsChanges();
    }

}
