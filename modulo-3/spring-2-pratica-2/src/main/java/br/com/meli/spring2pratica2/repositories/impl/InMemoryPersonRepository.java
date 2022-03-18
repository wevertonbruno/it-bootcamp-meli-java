package br.com.meli.spring2pratica2.repositories.impl;

import br.com.meli.spring2pratica2.entities.Person;
import br.com.meli.spring2pratica2.repositories.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryPersonRepository implements PersonRepository {

    private List<Person> data = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        return data.stream().collect(Collectors.toList());
    }

    @Override
    public void create(Person person) {
        data.add(person);
    }
}
