package br.com.meli.spring2pratica2.controllers;

import br.com.meli.spring2pratica2.services.DTO.PersonDTO;
import br.com.meli.spring2pratica2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<PersonDTO> response = personService.findAll();
        return ResponseEntity.ok(response);
    }
}
