package br.com.meli.spring2pratica2.entities;

public enum SportNivel {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final Integer code;

    SportNivel(Integer code) {
        this.code = code;
    }
}
