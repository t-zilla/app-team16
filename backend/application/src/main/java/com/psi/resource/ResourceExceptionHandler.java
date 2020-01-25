package com.psi.resource;

import com.psi.security.dto.AuthResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class)
    protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    protected ResponseEntity<AuthResponseDto> handleAuthenticationException(RuntimeException ex) {
        return new ResponseEntity<>(new AuthResponseDto(false, "Sorry, You're not authorized to access this resource."),
                HttpStatus.BAD_REQUEST);
    }

}
