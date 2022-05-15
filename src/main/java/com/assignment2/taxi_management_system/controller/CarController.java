package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @RequestMapping(path = "*/cars", method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(path = "/admin/cars", method = RequestMethod.POST)
    public Long addCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @RequestMapping(path = "/admin/cars", method = RequestMethod.DELETE)
    public Long deleteCar(@RequestBody Car car){
        return carService.deleteCar(car);
    }

    @RequestMapping(path = "/admin/cars", method = RequestMethod.PUT)
    public Long updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "id")
    public Car findByID(@RequestParam("id") long id){
        return carService.findByID(id);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "vin")
    public Car findByVIN(@RequestParam("vin") String VIN){
        return carService.findByVIN(VIN);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "make")
    public List<Car> findByMake(@RequestParam("make") String make){
        return carService.findByMake(make);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "model")
    public List<Car> findByModel(@RequestParam("model") String model){
        return carService.findByModel(model);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "color")
    public List<Car> findByColor(@RequestParam("color") String color){
        return carService.findByColor(color);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "convertible")
    public List<Car> findByConvertible(@RequestParam("convertible") boolean convertible){
        return carService.findByConvertible(convertible);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "rate")
    public List<Car> findByRate(@RequestParam("rate") double rate){
        return carService.findByRate(rate);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "rating")
    public List<Car> findByRating(@RequestParam("rating") double rating){
        return carService.findByRating(rating);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "license_plate")
    public List<Car> findByLicensePlate(@RequestParam("license_plate") String license_plate){
        return carService.findByLicensePlate(license_plate);
    }
}