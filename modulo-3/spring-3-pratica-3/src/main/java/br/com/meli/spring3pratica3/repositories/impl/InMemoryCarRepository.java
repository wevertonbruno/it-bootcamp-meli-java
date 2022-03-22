package br.com.meli.spring3pratica3.repositories.impl;

import br.com.meli.spring3pratica3.entities.Car;
import br.com.meli.spring3pratica3.repositories.CarRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Repository
public class InMemoryCarRepository implements CarRepository {

    private List<Car> repository = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Car create(Car entity) {
        entity.setId(UUID.randomUUID());
        repository.add(entity);
        return entity;
    }

    @Override
    public Optional<Car> findById(UUID id) {
        return repository.stream().filter(car -> car.getId().equals(id)).findFirst();
    }

    @Override
    public List<Car> findAll() {
        return repository;
    }

    @Override
    public List<Car> findByDate(LocalDate since, LocalDate to) {
        Predicate<Car> dateSince = car -> {
            return car.getManufacturingDate().isAfter(since);
        };

        Predicate<Car> dateTo = car -> {
            return car.getManufacturingDate().isBefore(to);
        };

        return repository.stream().filter(dateSince).filter(dateTo).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByPrices(Integer since, Integer to) {
        Predicate<Car> priceSince = car -> {
            return car.getPrice().compareTo(since) > 0;
        };

        Predicate<Car> priceTo = car -> {
            return car.getPrice().compareTo(to) < 0;
        };

        return repository.stream().filter(priceSince).filter(priceTo).collect(Collectors.toList());
    }
}
