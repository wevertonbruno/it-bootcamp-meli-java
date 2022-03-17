package br.com.meli.spring1pratica2.services;

public interface CodigoMorseMapper {
    public Character getCharacter(String codigo);
    public String getCode(Character character);
}
