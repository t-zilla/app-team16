package com.psi.resource;

import com.psi.handler.SubjectCardHandler;
import com.psi.pdf.SubjectCardPdfGenerator;
import com.psi.subjectcard.dto.SubjectCardCreationDto;
import com.psi.subjectcard.dto.SubjectCardDto;
import com.psi.subjectcard.model.SubjectCard;
import com.psi.subjectcard.translator.SubjectCardTranslator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.diff.Change;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
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

    @GetMapping("/{id}")
    public SubjectCardDto getSubjectCard(@PathVariable("id") Long id) {
        return SubjectCardTranslator.toDto(subjectCardHandler.getSubjectCard(id));
    }

    @Secured({"ROLE_RESEARCHER", "ROLE_SYLLABUS_AUTHOR", "ROLE_ADMINISTRATOR"})
    @PostMapping
    public SubjectCardDto createSubjectCard(@RequestBody SubjectCardCreationDto dto) {
        return subjectCardHandler.createSubjectCard(dto);
    }

    @Secured({"ROLE_RESEARCHER", "ROLE_SYLLABUS_AUTHOR", "ROLE_ADMINISTRATOR"})
    @PutMapping("/{id}")
    public SubjectCardDto updateSubjectCard(@PathVariable("id") Long id,
                                            @RequestBody SubjectCardCreationDto dto) {
        return subjectCardHandler.updateSubjectCard(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeSubjectCard(@PathVariable("id") Long id) {
        subjectCardHandler.removeSubjectCard(id);
    }

    @GetMapping("/audit")
    public List<Change> getSubjectCardsChanges() {
        return subjectCardHandler.getSubjectCardsChanges();
    }

    @GetMapping(value = "/{id}/pdf")
    public ResponseEntity<InputStreamResource> getPdf(@PathVariable("id") Long id) {
        SubjectCard subjectCard = subjectCardHandler.getSubjectCard(id);

        ByteArrayInputStream bis = SubjectCardPdfGenerator.generate(subjectCard);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=subjectcard.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
