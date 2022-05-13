package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Driver;
import com.assignment2.taxi_management_system.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;
    @RequestMapping(path = "/drivers", method = RequestMethod.GET)
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.POST)
    public Long addDriver(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.DELETE)
    public Long deleteDriver(@RequestBody Driver driver){
        return driverService.deleteDriver(driver);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.PUT)
    public Long updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.GET, params = "id")
    public Driver findByID(@RequestParam("id") long id){
        return driverService.findByID(id);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.GET, params = "name")
    public List<Driver> findByName(@RequestParam("name") String name){
        return driverService.findByName(name);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.GET, params = "phone_number")
    public List<Driver> findByPhoneNumber(@RequestParam("phone_number") String phone_number){
        return driverService.findByPhoneNumber(phone_number);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.GET, params = "rating")
    public List<Driver> findByRating(@RequestParam("rating") double rating){
        return driverService.findByRating(rating);
    }
}
