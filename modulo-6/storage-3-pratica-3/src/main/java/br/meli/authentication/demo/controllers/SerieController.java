package br.meli.authentication.demo.controllers;

import br.meli.authentication.demo.entities.Serie;
import br.meli.authentication.demo.services.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/series")
public class SerieController {

    private final SerieService movieService;

    public SerieController(SerieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/seasons-count")
    public ResponseEntity<List<Serie>> searchCountSeasons(@RequestParam Long count){
        List<Serie> series = movieService.findBySeasonCountGreaterThan(count);
        return ResponseEntity.ok(series);
    }
}
