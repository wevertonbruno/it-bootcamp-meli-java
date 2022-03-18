package br.com.meli.spring2pratica1.controllers;

import br.com.meli.spring2pratica1.controllers.DTO.ErrorDTO;
import br.com.meli.spring2pratica1.controllers.DTO.ResponseDTO;
import br.com.meli.spring2pratica1.services.IdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
public class Controller {

    private IdadeService idadeService;

    @Autowired
    public Controller(IdadeService idadeService) {
        this.idadeService = idadeService;
    }

    @GetMapping("data/{dia}/{mes}/{ano}")
    public ResponseEntity<?> getIdade(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer ano){

        try{
            Integer idade = idadeService.getIdadeFromDate(LocalDate.of(ano, mes, dia));
            return ResponseEntity.ok(new ResponseDTO(idade));
        }catch (DateTimeException e){
            return ResponseEntity.badRequest().body(new ErrorDTO("Data inválida", HttpStatus.BAD_REQUEST));
        }
    }
}
