package br.meli.authentication.demo.services;

import br.meli.authentication.demo.entities.Actor;

import java.util.List;

public interface ActorService {
    Actor create(Actor actor);
    Actor update(Long id, Actor body);
    List<Actor> findAll();
    Actor findById(Long id);
    void delete(Long id);
}
