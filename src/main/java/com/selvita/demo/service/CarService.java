package com.selvita.demo.service;

import com.selvita.demo.model.Car;

import java.util.List;

public interface CarService {

//  1. Napisz endpoint, który pobierze wszystkie rekordy
    List<Car> findAll();

//  2. Napisz endpoint, który pobierze rekordy po danym property np. po brandName
    List<Car> findByBrandName(String brandName);

//  3. Napisz endpoint, który pobierze rekordy, których rok produkcji jest w danym zakresie
    List<Car> findByProductionYearBetween(Long start, Long end);

//  4. Napisz endpoint, który doda nowy rekord
    Car save(Car newCar);

//  5. Napisz endpoint, który zmodyfikuje rekord
    Car update(Car newCar, Long id);

    void deleteById(Long id);
}
