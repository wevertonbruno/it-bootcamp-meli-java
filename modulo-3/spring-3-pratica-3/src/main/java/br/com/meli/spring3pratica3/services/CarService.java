package br.com.meli.spring3pratica3.services;

import br.com.meli.spring3pratica3.entities.Car;
import br.com.meli.spring3pratica3.repositories.CarRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return carRepository.create(car);
    }

    public Car findById(String id) {
        return carRepository.findById(UUID.fromString(id)).orElseThrow(() -> new IllegalArgumentException("Veiculo nao encontrado."));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findByDate(LocalDate since, LocalDate to) {
        return carRepository.findByDate(since, to);
    }

    public List<Car> findByPrices(Integer since, Integer to) {
        return carRepository.findByPrices(since, to);
    }
}
