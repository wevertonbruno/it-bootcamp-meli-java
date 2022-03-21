package com.example.spring3pratica1.services;

import com.example.spring3pratica1.entities.Personagem;
import com.example.spring3pratica1.repositories.PersonagemRepository;
import com.example.spring3pratica1.services.DTO.PersonagemDTO;
import com.example.spring3pratica1.controllers.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonagemService {

    private PersonagemRepository personagemRepository;

    @Autowired
    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public PersonagemDTO findByNameContaining(String name){
        Optional<Personagem> personagem = personagemRepository.findByNameContaining(name);

        return personagem
                .map(PersonagemDTO::fromPersonagem)
                .orElseThrow(() -> new EntityNotFoundException("Personagem com nome " + name + " nao encontrado."));
    }
}
