package br.com.meli.spring2pratica2.repositories;

import br.com.meli.spring2pratica2.entities.Sport;

import java.util.List;

public interface SportRepository {
    public List<Sport> findAll();
    public Sport findByName(String name);
    public void create(Sport sport);
}
