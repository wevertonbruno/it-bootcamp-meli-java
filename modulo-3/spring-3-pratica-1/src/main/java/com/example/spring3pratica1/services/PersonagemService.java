package com.example.spring3pratica1.services;

import com.example.spring3pratica1.repositories.PersonagemRepository;
import com.example.spring3pratica1.services.DTO.PersonagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonagemService {

    private PersonagemRepository personagemRepository;

    @Autowired
    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public List<PersonagemDTO> findByNameContaining(String name){
        return personagemRepository.findByNameContaining(name)
                .stream().map(PersonagemDTO::fromPersonagem)
                .collect(Collectors.toList());
    }
}
