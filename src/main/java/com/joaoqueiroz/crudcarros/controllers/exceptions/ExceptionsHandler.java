package com.joaoqueiroz.crudcarros.controllers.exceptions;


import com.joaoqueiroz.crudcarros.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException e, HttpServletRequest req){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(e.getMessage(), "Not found", status.value(), LocalDateTime.now(), req.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
