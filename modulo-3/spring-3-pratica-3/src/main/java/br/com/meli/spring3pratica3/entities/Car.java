package br.com.meli.spring3pratica3.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Car extends Entity{
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private Integer countOfOwners;

    private List<Service> services;

    public Car(String brand, String model, LocalDate manufacturingDate, Integer numberOfKilometers, Integer doors, Integer price, String currency, Integer countOfOwners, List<Service> services) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Integer getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(Integer numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(Integer countOfOwners) {
        this.countOfOwners = countOfOwners;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + this.getId() +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", numberOfKilometers=" + numberOfKilometers +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", countOfOwners=" + countOfOwners +
                '}';
    }
}
