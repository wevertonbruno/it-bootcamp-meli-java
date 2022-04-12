package br.meli.authentication.demo.services.impl;

import br.meli.authentication.demo.dto.MovieResponseDTO;
import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.Movie;
import br.meli.authentication.demo.repositories.ActorRepository;
import br.meli.authentication.demo.repositories.MovieRepository;
import br.meli.authentication.demo.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public MovieResponseDTO create(Movie movie) {
        Movie newMovie = movieRepository.save(movie);
        return MovieResponseDTO.of(newMovie);
    }

    @Override
    public MovieResponseDTO update(Long id, Movie body) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found!"));

        movie.setAwards(body.getAwards());
        movie.setTitle(body.getTitle());
        movie.setRating(body.getRating());
        movie.setLength(body.getLength());
        movie.setReleaseDate(body.getReleaseDate());
        movie = movieRepository.save(movie);

        return MovieResponseDTO.of(movie);
    }

    @Override
    public List<MovieResponseDTO> findAll() {
        return movieRepository.findAll().stream().map(MovieResponseDTO::of).collect(Collectors.toList());
    }

    @Override
    public MovieResponseDTO findById(Long id) {
        return movieRepository.findById(id)
                .map(MovieResponseDTO::of)
                .orElseThrow(
                () -> new RuntimeException("Movie not found!"));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        movieRepository.deleteById(id);
    }
}
