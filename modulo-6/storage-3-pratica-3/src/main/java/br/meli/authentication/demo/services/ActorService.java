package br.meli.authentication.demo.services;

import br.meli.authentication.demo.dto.ActorResponseDTO;
import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.Episode;
import br.meli.authentication.demo.entities.Movie;

import java.util.List;

public interface ActorService {
    ActorResponseDTO create(Actor actor);
    ActorResponseDTO update(Long id, Actor body);
    List<ActorResponseDTO> findAll();
    Actor findById(Long id);
    void delete(Long id);
    List<ActorResponseDTO> findWithFavoriteMovie();
    List<ActorResponseDTO> findByRatingGreaterThan(Double rating);
    List<Episode> findAllEpisodesById(Long id);
}
