package com.example.spring3pratica1.repositories.impl;

import com.example.spring3pratica1.entities.Personagem;

import java.io.Serializable;

public class PersonagemMapper implements Serializable {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public PersonagemMapper(String name, String height, String mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public PersonagemMapper() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    private Integer normalizeInteger(String i){
        if(i == null) return null;
        String formated = i
                .replace(",", "");

        return Integer.valueOf(formated);
    }

    private Double normalizeDouble(String i){
        if(i == null) return null;
        String formated = i
                .replace(",", "");
        return Double.valueOf(formated);
    }

    private String normalizeNA(String i){
        return i.equals("NA") ? null : i;
    }

    public Personagem toPersonagem(){
        return new Personagem(
                normalizeNA(this.name),
                normalizeInteger(normalizeNA(this.height)),
                normalizeDouble(normalizeNA(this.mass)),
                normalizeNA(this.hair_color),
                normalizeNA(this.skin_color),
                normalizeNA(this.eye_color),
                normalizeNA(this.birth_year),
                normalizeNA(this.gender),
                normalizeNA(this.homeworld),
                normalizeNA(this.species)
        );
    }
}
