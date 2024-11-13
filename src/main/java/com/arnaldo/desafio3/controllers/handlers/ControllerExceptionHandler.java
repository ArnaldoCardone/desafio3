package com.arnaldo.desafio3.controllers.handlers;

import com.arnaldo.desafio3.dto.CustomError;
import com.arnaldo.desafio3.services.exceptions.ResourceNotFindException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFindException.class)
    public ResponseEntity<CustomError> resourceNotFind(ResourceNotFindException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(),e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
