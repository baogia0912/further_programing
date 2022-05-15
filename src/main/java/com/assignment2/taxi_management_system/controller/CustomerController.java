package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Customer;
import com.assignment2.taxi_management_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(path = "/admin/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.POST)
    public long addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.DELETE)
    public long deleteCustomer(@RequestBody Customer customer){
        return customerService.deleteCustomer(customer);
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.PUT)
    public long updateCustomers(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.GET, params = "id")
    public Customer findByID(@RequestParam("id") long id){
        return customerService.findByID(id);
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.GET, params = "name")
    public List<Customer> findByName(@RequestParam("name") String name){
        return customerService.findByName(name);
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.GET, params = "phone_number")
    public List<Customer> findByPhoneNumber(@RequestParam("phone_number") String phone_number){
        return customerService.findByPhoneNumber(phone_number);
    }

    @RequestMapping(path = {"/admin/customers", "/customer/customers"}, method = RequestMethod.GET, params = "address")
    public List<Customer> findByAddress(@RequestParam("address") String address){
        return customerService.findByAddress(address);
    }
}
