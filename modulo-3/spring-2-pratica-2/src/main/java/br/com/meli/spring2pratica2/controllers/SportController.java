package br.com.meli.spring2pratica2.controllers;

import br.com.meli.spring2pratica2.entities.Sport;
import br.com.meli.spring2pratica2.repositories.SportRepository;
import br.com.meli.spring2pratica2.services.DTO.SportNivelDTO;
import br.com.meli.spring2pratica2.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {
    private SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping
    public ResponseEntity<List<Sport>> findAll(){
        List<Sport> sports = sportService.findAll();
        return ResponseEntity.ok(sports);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SportNivelDTO> findByName(@PathVariable String name){
        SportNivelDTO response = sportService.findByName(name);
        return ResponseEntity.ok(response);
    }
}
