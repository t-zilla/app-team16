package com.psi.term.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class ZzuLimitException extends RuntimeException {

    public ZzuLimitException(String message) {
        super(message);
    }
}
