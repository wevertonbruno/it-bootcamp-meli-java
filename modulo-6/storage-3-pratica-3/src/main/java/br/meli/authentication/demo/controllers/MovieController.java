package br.meli.authentication.demo.controllers;

import br.meli.authentication.demo.dto.ActorResponseDTO;
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

    @GetMapping("/{id}/actors")
    public ResponseEntity<List<ActorResponseDTO>> showActors(
            @PathVariable Long id){
        List<ActorResponseDTO> actors = movieService.findActors(id);
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<MovieResponseDTO>> findByGenre(@PathVariable Long genreId){
        List<MovieResponseDTO> movies = movieService.findByGenreId(genreId);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/actor-rating/filter")
    public ResponseEntity<List<MovieResponseDTO>> showActors(@RequestParam(required = false, name = "gt") Double greaterThan){
        List<MovieResponseDTO> movies = movieService.findByActorsRatingGreaterThan(greaterThan);
        return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
