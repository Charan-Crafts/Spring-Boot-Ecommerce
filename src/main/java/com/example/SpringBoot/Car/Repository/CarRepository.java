package com.example.SpringBoot.Car.Repository;

import com.example.SpringBoot.Car.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car , Long> {

}
