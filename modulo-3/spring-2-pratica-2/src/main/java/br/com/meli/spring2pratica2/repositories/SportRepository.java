package br.com.meli.spring2pratica2.repositories;

import br.com.meli.spring2pratica2.entities.Sport;

import java.util.List;
import java.util.Optional;

public interface SportRepository {
    public List<Sport> findAll();
    public Optional<Sport> findByName(String name);
    public void create(Sport sport);
}
