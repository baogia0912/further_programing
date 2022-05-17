package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Customer;
import com.assignment2.taxi_management_system.service.CustomerService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllCustomers() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Bao", "abc", "0000", null));
        customerList.add(new Customer(2, "Bao", "abc", "0000", null));
        customerList.add(new Customer(3, "Bao", "abc", "0000", null));

        Mockito.when(customerService.getAllCustomers(Optional.empty(), Optional.empty())).thenReturn(customerList);
        MvcResult mvcResult = mvc.perform(get("/admin/customers")
                .param("page", "1")
                .param("limit", "10")
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getBooking() {
    }

    @Test
    void addCustomer() throws Exception {
        Customer bao = new Customer(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(customerService.saveCustomer(bao)).thenReturn(bao);
        MvcResult mvcResult = mvc.perform(post("/admin/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomers() {
    }

    @Test
    void findByID() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByPhoneNumber() {
    }

    @Test
    void findByAddress() {
    }
}