package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Customer;
import com.assignment2.taxi_management_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(path = "/customers", method = RequestMethod.POST)
    public long addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @RequestMapping(path = "/customers", method = RequestMethod.DELETE)
    public long deleteCustomer(@RequestBody Customer customer){
        return customerService.deleteCustomer(customer);
    }

    @RequestMapping(path = "/customers", method = RequestMethod.PUT)
    public long updateCustomers(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
