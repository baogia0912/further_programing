package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Driver;
import com.assignment2.taxi_management_system.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;
    @RequestMapping(path = "/admin/drivers", method = RequestMethod.GET)
    public List<Driver> getAllDrivers(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                      @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return driverService.getAllDrivers(page, limit);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.POST)
    public Long addDriver(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.DELETE)
    public Long deleteDriver(@RequestBody Driver driver){
        return driverService.deleteDriver(driver);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.PUT)
    public Long updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.GET, params = "id")
    public Driver findByID(@RequestParam("id") long id){
        return driverService.findByID(id);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.GET, params = "name")
    public List<Driver> findByName(@RequestParam("name") String name, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                   @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return driverService.findByName(name, page, limit);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.GET, params = "license_number")
    public Driver findByLicenseNumber(@RequestParam("license_number") String license_number){
        return driverService.findByLicenseNumber(license_number);
    }

    @RequestMapping(path = {"/admin/drivers","/driver/drivers"}, method = RequestMethod.GET, params = "phone_number")
    public List<Driver> findByPhoneNumber(@RequestParam("phone_number") String phone_number, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                          @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return driverService.findByPhoneNumber(phone_number, page, limit);
    }

    @RequestMapping(path =  "/admin/drivers" method = RequestMethod.GET, params = "rating")
    public List<Driver> findByRating(@RequestParam("rating") double rating, @RequestParam(value = "page", required = false) Optional<Integer> page,
                                     @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return driverService.findByRating(rating, page, limit);
    }
}
