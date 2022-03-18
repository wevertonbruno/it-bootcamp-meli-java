package br.com.meli.spring2pratica2.services.DTO;

import br.com.meli.spring2pratica2.entities.SportNivel;

import java.io.Serializable;

public class SportNivelDTO implements Serializable {
    private SportNivel nivel;

    public SportNivelDTO(SportNivel nivel) {
        this.nivel = nivel;
    }

    public SportNivel getNivel() {
        return nivel;
    }

    public void setNivel(SportNivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "SportNivelDTO{" +
                "nivel=" + nivel +
                '}';
    }
}
