package br.meli.authentication.demo.services.impl;

import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.repositories.ActorRepository;
import br.meli.authentication.demo.services.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(Long id, Actor body) {
        Actor actor = findById(id);
        actor.setFirstName(body.getFirstName());
        actor.setLastName(body.getLastName());
        actor.setRating(body.getRating());
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Actor not found!"));
    }

    @Override
    public void delete(Long id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
    }
}
