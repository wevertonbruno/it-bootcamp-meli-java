package br.com.meli.spring3pratica3.controllers;

import br.com.meli.spring3pratica3.entities.Car;
import br.com.meli.spring3pratica3.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("v1/api/veiculos")
public class CarContoller {
    private CarService carService;

    @Autowired
    public CarContoller(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car carBody) {
        Car car = carService.create(carBody);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(String id) {
        Car car = carService.findById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Car>> findByDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(carService.findByDate(
                LocalDate.parse(since),
                LocalDate.parse(to)
        ));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Car>> findByPrices(@RequestParam Integer since, @RequestParam Integer to) {
        return ResponseEntity.ok(carService.findByPrices(since, to));
    }
}
