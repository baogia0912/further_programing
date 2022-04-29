package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Driver;
import com.assignment2.taxi_management_system.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public long addDriver(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.DELETE)
    public long deleteDriver(@RequestBody Driver driver){
        return driverService.deleteDriver(driver);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.PUT)
    public long updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }
}
