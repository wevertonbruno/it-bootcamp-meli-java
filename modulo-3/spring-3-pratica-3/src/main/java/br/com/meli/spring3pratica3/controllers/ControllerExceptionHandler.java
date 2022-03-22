package br.com.meli.spring3pratica3.controllers;

import br.com.meli.spring3pratica3.exceptions.EntityNotFoundException;
import br.com.meli.spring3pratica3.exceptions.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardException> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request){
        StandardException exception = StandardException.notFound(e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
