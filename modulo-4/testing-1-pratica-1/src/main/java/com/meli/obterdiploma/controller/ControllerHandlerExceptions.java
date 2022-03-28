package com.meli.obterdiploma.controller;

import com.meli.obterdiploma.model.GeneralErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerHandlerExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<GeneralErrorDTO>> methodArgumentNotValid(MethodArgumentNotValidException e){
        List<GeneralErrorDTO> errors = e.getAllErrors().stream().map(
                error -> new GeneralErrorDTO("Argumento Invalido", Instant.now(), error.getDefaultMessage())
        ).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);
    }
}
