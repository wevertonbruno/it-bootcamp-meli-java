package br.meli.authentication.demo.controllers;

import br.meli.authentication.demo.dto.MovieResponseDTO;
import br.meli.authentication.demo.entities.Movie;
import br.meli.authentication.demo.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieResponseDTO> create(@RequestBody Movie movieDto){
        MovieResponseDTO newMovie = movieService.create(movieDto);
        return ResponseEntity.ok(newMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> update(@PathVariable Long id, @RequestBody Movie movieUpdateDto){
        MovieResponseDTO updatedMovie = movieService.update(id, movieUpdateDto);
        return ResponseEntity.ok(updatedMovie);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> findAll(){
        List<MovieResponseDTO> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> findById(@PathVariable Long id){
        MovieResponseDTO movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
