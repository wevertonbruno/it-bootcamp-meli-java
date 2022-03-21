package com.example.spring3pratica1.controllers;

import com.example.spring3pratica1.services.DTO.PersonagemDTO;
import com.example.spring3pratica1.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star-wars")
public class PersonagemController {

    private PersonagemService personagemService;

    @Autowired
    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping("/search")
    public ResponseEntity<PersonagemDTO> findByNameContaining(
            @RequestParam String name
    ){
        PersonagemDTO personagemDTO = personagemService.findByNameContaining(name);
        return ResponseEntity.ok(personagemDTO);
    }
}
