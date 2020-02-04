package com.psi.syllabus.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class TermsLimitException extends RuntimeException {

    public TermsLimitException(String message) {
        super(message);
    }

}
