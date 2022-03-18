package br.com.meli.spring2pratica2.repositories;

import br.com.meli.spring2pratica2.entities.Person;

import java.util.List;

public interface PersonRepository {
    public List<Person> findAll();
    public void create(Person person);
}
