package com.example.SpringBoot.Car.Controllers;

import com.example.SpringBoot.Car.Models.Car;
import com.example.SpringBoot.Car.Services.CarServicesImpl;
import jakarta.persistence.GeneratedValue;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarControllers {

    @Autowired
    CarServicesImpl carServices;

    @GetMapping("/getCars")
    public List<Car> getAllCars(){
        return carServices.getAllCars();
    }

    @PostMapping("/admin/addCar")
    public String addNewCar(@RequestBody Car car){
        return carServices.addNewCar(car);
    }

    @PutMapping("/admin/updateCar/{carId}")
    public ResponseEntity<String> updateCarDetails(@RequestBody Car car,@PathVariable long carId){
        try{
            return carServices.updateCar(car,carId);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @DeleteMapping("/admin/deleteCar/{carId}")
    public ResponseEntity<String> deleteCar(@PathVariable long carId){
        try{
            return carServices.deleteCar(carId);
        }catch (ResponseStatusException e){
            return new ResponseEntity(e.getReason(),e.getStatusCode());
        }
    }
}
