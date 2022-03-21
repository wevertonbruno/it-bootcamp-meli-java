package com.example.spring3pratica1.services.DTO;

import com.example.spring3pratica1.entities.Personagem;

import java.io.Serializable;

public class PersonagemDTO implements Serializable {
    private String name;
    private Integer height;
    private Double mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonagemDTO(String name, Integer height, Double mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public static PersonagemDTO fromPersonagem(Personagem personagem){
        return new PersonagemDTO(
                personagem.getName(),
                personagem.getHeight(),
                personagem.getMass(),
                personagem.getGender(),
                personagem.getHomeworld(),
                personagem.getSpecies()
        );
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Double getMass() {
        return mass;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "PersonagemDTO{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
