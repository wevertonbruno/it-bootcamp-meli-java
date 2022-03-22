package br.com.meli.spring3pratica3.repositories;

import br.com.meli.spring3pratica3.entities.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CarRepository extends CRUDRepository<Car, UUID>{
    List<Car> findByDate (LocalDate since, LocalDate to);
    List<Car> findByPrices (Integer since, Integer to);
}
