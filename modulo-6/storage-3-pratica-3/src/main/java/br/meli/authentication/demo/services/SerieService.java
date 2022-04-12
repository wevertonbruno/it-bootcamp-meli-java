package br.meli.authentication.demo.services;

import br.meli.authentication.demo.entities.Serie;

import java.util.List;

public interface SerieService {
    List<Serie> findBySeasonCountGreaterThan(Long count);
}
