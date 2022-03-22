package com.example.spring3pratica1.repositories;

import com.example.spring3pratica1.entities.Personagem;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository {
    public List<Personagem> findByNameContaining(String contains);
}
