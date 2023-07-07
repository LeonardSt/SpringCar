package com.selvita.demo.repo;

//        1. Napisz endpoint, który pobierze wszystkie rekordy +
//        2. Napisz endpoint, który pobierze rekordy po danym property np. po brandName +
//        3. Napisz endpoint, który pobierze rekordy, których rok produkcji jest w danym zakresie +
//        4. Napisz endpoint, który doda nowy rekord +
//        5. Napisz endpoint, który zmodyfikuje rekord +
//
//        damian.szwajkos@selvita.com
//
//        radoslaw.myc@selvita.com

import com.selvita.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findByBrandName(String brandName);

    List<Car> findByProductionYearBetween(Long start, Long end);

}
