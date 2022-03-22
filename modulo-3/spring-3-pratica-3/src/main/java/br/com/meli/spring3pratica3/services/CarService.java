package br.com.meli.spring3pratica3.services;

import br.com.meli.spring3pratica3.entities.Car;
import br.com.meli.spring3pratica3.exceptions.EntityNotFoundException;
import br.com.meli.spring3pratica3.repositories.CarRepository;
import br.com.meli.spring3pratica3.services.DTO.UsedCarDTO;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final static Pattern UUID_REGEX_PATTERN =
            Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return carRepository.create(car);
    }

    public Car findById(String id) {
        if(!isValidUUID(id)){
            throw new EntityNotFoundException("There is no car with ID(" + id + ").");
        }

        return carRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new EntityNotFoundException("There is no car with ID(" + id + ")."));
    }

    public List<UsedCarDTO> findAll() {
        return carRepository.findAll().stream().map(UsedCarDTO::fromCar).collect(Collectors.toList());
    }

    public List<Car> findByDate(LocalDate since, LocalDate to) {
        return carRepository.findByDate(since, to);
    }

    public List<Car> findByPrices(Integer since, Integer to) {
        return carRepository.findByPrices(since, to);
    }

    private static boolean isValidUUID(String str) {
        if (str == null) {
            return false;
        }
        return UUID_REGEX_PATTERN.matcher(str).matches();
    }
}
