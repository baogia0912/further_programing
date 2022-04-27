package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.assignment2.taxi_management_system.model.Car;
import java.util.List;
@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @RequestMapping(path = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(path = "/cars", method = RequestMethod.POST)
    public long addCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.DELETE)
    public long deleteCar(@RequestBody Car car){
        return carService.deleteCar(car);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.PUT)
    public long updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }
}