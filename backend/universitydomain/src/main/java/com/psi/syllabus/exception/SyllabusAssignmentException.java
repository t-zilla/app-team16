package com.psi.syllabus.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SyllabusAssignmentException extends RuntimeException {

    public SyllabusAssignmentException(String message) {
        super(message);
    }
}
