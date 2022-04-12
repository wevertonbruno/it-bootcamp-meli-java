package br.meli.authentication.demo.services.impl;

import br.meli.authentication.demo.entities.Serie;
import br.meli.authentication.demo.repositories.SerieRepository;
import br.meli.authentication.demo.services.SerieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {
    private final SerieRepository serieRepository;

    public SerieServiceImpl(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<Serie> findBySeasonCountGreaterThan(Long count) {
        return serieRepository.findBySeasonsCountGreaterThan(count);
    }
}
