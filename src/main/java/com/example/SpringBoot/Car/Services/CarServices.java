package com.example.SpringBoot.Car.Services;

import com.example.SpringBoot.Car.Models.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarServices {

    public List<Car> getAllCars();

    public String addNewCar(Car car);

    public ResponseEntity<String> updateCar(Car car, long carId);

    public ResponseEntity<String> deleteCar(long carId);

}
