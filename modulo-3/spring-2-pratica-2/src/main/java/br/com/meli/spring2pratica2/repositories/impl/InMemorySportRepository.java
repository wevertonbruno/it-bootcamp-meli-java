package br.com.meli.spring2pratica2.repositories.impl;

import br.com.meli.spring2pratica2.entities.Sport;
import br.com.meli.spring2pratica2.repositories.SportRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemorySportRepository implements SportRepository {
    List<Sport> data = new ArrayList<>();

    @Override
    public List<Sport> findAll() {
        return data.stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Sport> findByName(String name) {
        return data.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public void create(Sport sport) {
        data.add(sport);
    }
}
