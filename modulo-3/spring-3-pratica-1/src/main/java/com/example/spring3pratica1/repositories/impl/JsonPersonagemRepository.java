package com.example.spring3pratica1.repositories.impl;

import com.example.spring3pratica1.entities.Personagem;
import com.example.spring3pratica1.repositories.PersonagemRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class JsonPersonagemRepository implements PersonagemRepository {
    private List<Personagem> repository;

    public JsonPersonagemRepository() throws IOException {
        repository = JsonUtil.readAsList("file:src/main/resources/starwars.json", PersonagemMapper[].class)
                .stream()
                .map(PersonagemMapper::toPersonagem)
                .collect(Collectors.toList());
    }

    @Override
    public List<Personagem> findByNameContaining(String name) {
        // Function to find name that constains string
        Predicate<Personagem> hasName = personagem -> personagem.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT));

        return repository.stream()
                .filter(hasName)
                .collect(Collectors.toList());
    }
}
