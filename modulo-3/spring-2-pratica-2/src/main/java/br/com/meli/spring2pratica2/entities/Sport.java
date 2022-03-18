package br.com.meli.spring2pratica2.entities;

import java.util.Objects;

public class Sport {
    private String name;
    private SportNivel nivel;

    private Sport(String name, SportNivel nivel) {
        this.name = name;
        this.nivel = nivel;
    }

    public static Sport of(String name, SportNivel nivel){
        return new Sport(name, nivel);
    }

    public String getName() {
        return name;
    }

    public SportNivel getNivel() {
        return nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return Objects.equals(name, sport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
