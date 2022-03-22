package br.com.meli.spring3pratica3.repositories;

import br.com.meli.spring3pratica3.entities.Entity;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<MainClass extends Entity, IdClass> {
    MainClass create(MainClass entity);
    Optional<MainClass> findById(IdClass id);
    List<MainClass> findAll();
}
