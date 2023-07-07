package com.selvita.demo.service;

import com.selvita.demo.model.Car;
import com.selvita.demo.repo.CarRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;

    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public void deleteById(Long id) {
        carRepo.deleteById(id);
    }

    @Override
    public List<Car> findAll() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> findByBrandName(String brandName) {
        return carRepo.findByBrandName(brandName);
    }

    @Override
    public List<Car> findByProductionYearBetween(Long start, Long end) {
        return carRepo.findByProductionYearBetween(start, end);
    }

    @Override
    public Car save(Car newCar) {
        return carRepo.save(newCar);
    }

    @Override
    public Car update(Car newCar, Long id) {
        return carRepo.findById(id)
            .map(car -> {
                car.setBrandName(newCar.getBrandName());
                car.setModel(newCar.getModel());
                car.setProductionYear(newCar.getProductionYear());
                car.setPrice(newCar.getPrice());
                car.setColor(newCar.getColor());
                return carRepo.save(car);
            })
            .orElseGet(() -> carRepo.save(newCar));
    }

}
