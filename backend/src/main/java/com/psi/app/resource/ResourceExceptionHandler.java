package com.psi.app.resource;

import com.psi.app.security.dto.AuthResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.text.MessageFormat.format;

@ControllerAdvice
@Slf4j
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AuthenticationException.class)
    protected ResponseEntity<AuthResponseDto> handleAuthenticationException(RuntimeException ex) {
        log.info(format("Authentication exception occurs, message: {0}", ex.getMessage()));

        return new ResponseEntity<>(new AuthResponseDto(false, "Sorry, You're not authorized to access this resource."),
                HttpStatus.BAD_REQUEST);
    }
}
