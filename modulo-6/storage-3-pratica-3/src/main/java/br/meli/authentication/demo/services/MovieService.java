package br.meli.authentication.demo.services;

import br.meli.authentication.demo.dto.ActorResponseDTO;
import br.meli.authentication.demo.dto.MovieResponseDTO;
import br.meli.authentication.demo.entities.Movie;

import java.util.List;

public interface MovieService {
    MovieResponseDTO create(Movie movie);
    MovieResponseDTO update(Long id, Movie body);
    List<MovieResponseDTO> findAll();
    MovieResponseDTO findById(Long id);
    void delete(Long id);
    List<ActorResponseDTO> findActors(Long movieId);
    List<MovieResponseDTO> findByActorsRatingGreaterThan(Double rating);
    List<MovieResponseDTO> findByGenreId(Long genreId);
}
