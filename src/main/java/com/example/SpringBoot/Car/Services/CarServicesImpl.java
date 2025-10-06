package com.example.SpringBoot.Car.Services;

import com.example.SpringBoot.Car.Models.Car;
import com.example.SpringBoot.Car.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CarServicesImpl implements CarServices{

    @Autowired
    CarRepository carRepository ;


    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public String addNewCar(Car car) {
        carRepository.save(car);
        return "Car added";
    }

    @Override
    public ResponseEntity<String> updateCar(Car car, long carId) {
        Optional<Car> carDetails = carRepository.findById(carId);

        if(carDetails.isPresent()){

            // Do something
            Car currentCar = carDetails.get();

            currentCar.setMake(car.getMake());
            currentCar.setModel(car.getModel());
            currentCar.setPrice(car.getPrice());

            carRepository.save(currentCar);

            return ResponseEntity.ok("Car is updated");
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Car Not founded");
        }

    }

    @Override
    public ResponseEntity<String> deleteCar(long carId) {

        Optional<Car> isExists = carRepository.findById(carId);

        if(isExists.isPresent()){

            Car tempCar = isExists.get();

            carRepository.delete(tempCar);

            return ResponseEntity.ok("Car deleted successfully !");
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not founded");
        }
    }
}
