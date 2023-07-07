package com.selvita.demo.controller;

import com.selvita.demo.model.Car;
import com.selvita.demo.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    List<Car> getAll() {
        return carService.findAll();
    }

    @GetMapping(path = "/cars", params = "brandName")
    List<Car> getByBrandName(@RequestParam String brandName) {
        return carService.findByBrandName(brandName);
    }

    @GetMapping(path = "/cars", params = {"start", "end"} )
    List<Car> getByProductionYearBetween(@RequestParam Long start, @RequestParam Long end) {
        return carService.findByProductionYearBetween(start, end);
    }

    @PostMapping("/cars")
    Car newCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
    }

    @PutMapping("/cars/{id}")
    Car updateCar(@RequestBody Car car, @PathVariable Long id) {
        return carService.update(car, id);
    }

}
