package br.meli.authentication.demo.services.impl;

import br.meli.authentication.demo.dto.ActorResponseDTO;
import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.Episode;
import br.meli.authentication.demo.entities.Movie;
import br.meli.authentication.demo.repositories.ActorRepository;
import br.meli.authentication.demo.repositories.MovieRepository;
import br.meli.authentication.demo.services.ActorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public ActorResponseDTO create(Actor actor) {
        return ActorResponseDTO.of(actorRepository.save(actor));
    }

    @Override
    public ActorResponseDTO update(Long id, Actor body) {
        Actor actor = findById(id);
        actor.setFirstName(body.getFirstName());
        actor.setLastName(body.getLastName());
        actor.setRating(body.getRating());
        return ActorResponseDTO.of(actorRepository.save(actor));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ActorResponseDTO> findAll() {
        return actorRepository.findAll()
                .stream().map(ActorResponseDTO::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    @Override
    public List<ActorResponseDTO> findWithFavoriteMovie() {
        return actorRepository.findByFavoriteMovieNotNull()
                .stream().map(ActorResponseDTO::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ActorResponseDTO> findByRatingGreaterThan(Double rating) {
        return actorRepository.findByRatingGreaterThan(rating)
                .stream().map(ActorResponseDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<Episode> findAllEpisodesById(Long id) {
        return actorRepository.findAllEpisodesById(id);
    }
}
