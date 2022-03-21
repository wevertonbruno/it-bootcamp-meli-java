package com.example.spring3pratica1;

import com.example.spring3pratica1.entities.Personagem;
import com.example.spring3pratica1.repositories.PersonagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Spring3Pratica1Application {
    public static void main(String[] args) {
        SpringApplication.run(Spring3Pratica1Application.class, args);
    }
}
