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
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.psi.subjectcard.model.SubjectCard;
import com.psi.pdf.SubjectCardPdfGenerator;

import java.io.ByteArrayInputStream;
import java.util.List;

import static java.text.MessageFormat.format;

@Slf4j
@RestController
@RequestMapping("/api/subject-cards")
@RequiredArgsConstructor
public class SubjectCardResource implements RestResource {

    private final SubjectCardHandler handler;

    @GetMapping
    public List<SubjectCardDto> getSubjectCards(@RequestParam(value = "subjectId", required = false) Long subjectId) {
        log.info(format("[{0}] requested Subject Cards list", getCurrentUsername()));

        return handler.getSubjectCards(subjectId);
    }

    @PutMapping("/{id}")
    public SubjectCardDto updateSubjectCard(@PathVariable("id") Long id,
                                            @RequestBody SubjectCardCreationDto dto) {
        return handler.updateSubjectCard(id, dto);
    }

    @GetMapping("/audit")
    public List<Change> getSubjectCardsChanges() {
        return handler.getSubjectCardsChanges();
    }

    @GetMapping(value = "/{id}/pdf")
    public ResponseEntity<InputStreamResource> getPdf(@PathVariable("id") Long id) {
        SubjectCard subjectCard = handler.getSubjectCard(id);

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
