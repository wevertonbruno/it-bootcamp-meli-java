package br.com.meli.spring2pratica2.services;

import br.com.meli.spring2pratica2.controllers.exceptions.EntityNotFound;
import br.com.meli.spring2pratica2.entities.Sport;
import br.com.meli.spring2pratica2.repositories.SportRepository;
import br.com.meli.spring2pratica2.services.DTO.SportNivelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {
    SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public SportNivelDTO findByName(String name){
        Sport sport = sportRepository.findByName(name);
        if(sport == null){
            throw new EntityNotFound();
        }
        return new SportNivelDTO(sport.getNivel());
    }

    public List<Sport> findAll(){
        return sportRepository.findAll();
    }
}
