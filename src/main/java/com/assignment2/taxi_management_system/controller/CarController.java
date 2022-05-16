package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @RequestMapping(path = "*/cars", method = RequestMethod.GET)
    public List<Car> getAllCars(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.getAllCars(page, limit);
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

    @RequestMapping(path = "/cars", method = RequestMethod.PATCH)
    public Long setDriver(@RequestBody Car car){
        return carService.setDriver(car);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "id")
    public Car findByID(@RequestParam("id") long id){
        return carService.findByID(id);
    }

    @RequestMapping(path = "*/cars", method = RequestMethod.GET, params = "vin")
    public Car findByVIN(@RequestParam("vin") String VIN){
        return carService.findByVIN(VIN);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "make")
    public List<Car> findByMake(@RequestParam("make") String make, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.findByMake(make, page, limit);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "model")
    public List<Car> findByModel(@RequestParam("model") String model, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                 @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.findByModel(model, page, limit);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "color")
    public List<Car> findByColor(@RequestParam("color") String color, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                 @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.findByColor(color, page, limit);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "convertible")
    public List<Car> findByConvertible(@RequestParam("convertible") boolean convertible, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                       @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.findByConvertible(convertible, page, limit);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "rate")
    public List<Car> findByRate(@RequestParam("rate") double rate, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.findByRate(rate, page, limit);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "rating")
    public List<Car> findByRating(@RequestParam("rating") double rating, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                  @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return carService.findByRating(rating, page, limit);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, params = "license_plate")
    public Car findByLicensePlate(@RequestParam("license_plate") String license_plate){
        return carService.findByLicensePlate(license_plate);
    }
}