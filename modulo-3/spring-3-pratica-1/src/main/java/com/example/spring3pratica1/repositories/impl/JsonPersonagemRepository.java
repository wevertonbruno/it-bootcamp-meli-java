package com.example.spring3pratica1.repositories.impl;

import com.example.spring3pratica1.entities.Personagem;
import com.example.spring3pratica1.repositories.PersonagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class JsonPersonagemRepository implements PersonagemRepository {
    private List<Personagem> repository;

    public JsonPersonagemRepository() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        PersonagemMapper[] personagens = objectMapper.readValue(
                new ClassPathResource("starwars.json").getFile(), PersonagemMapper[].class);

        repository = Arrays.asList(personagens).stream().map(PersonagemMapper::toPersonagem).collect(Collectors.toList());
    }

    @Override
    public Optional<Personagem> findByNameContaining(String name) {
        // Function to find name that constains string
        Predicate<Personagem> hasName = personagem -> personagem.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT));

        Optional<Personagem> personagemMatch = repository.stream()
                .filter(hasName)
                .findFirst();

        return personagemMatch;
    }
}
