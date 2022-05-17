package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Customer;
import com.assignment2.taxi_management_system.service.CustomerService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;


    @MockBean
    private CustomerService customerService;


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
                .with(csrf()))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(customerList, customerService.getAllCustomers(Optional.empty(), Optional.empty()));
    }

    @Test
    void getBooking() throws Exception {
        Customer bao = new Customer(1, "Bao", "abc", "0000", null);
        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when((customerService.getBookingDetails(bao))).thenReturn(bao.getBooking());

        MvcResult mvcResult = mvc.perform(get("/admin/customers/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(bao.getBooking(), customerService.getBookingDetails(bao));
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
        assertEquals(bao, customerService.saveCustomer(bao));
    }

    @Test
    void deleteCustomer() throws Exception {
        Customer bao = new Customer(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(customerService.deleteCustomer(bao)).thenReturn(bao.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/admin/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(bao.getId(), customerService.deleteCustomer(bao));
    }

    @Test
    void updateCustomers() throws Exception {
        Customer c1 = new Customer(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((customerService.updateCustomer(c1))).thenReturn(c1.getId());
        MvcResult mvcResult = mvc.perform(put("/admin/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1.getId(), customerService.updateCustomer(c1));
    }

    @Test
    void findByID() throws Exception {
        Customer c1 = new Customer(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((customerService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/customers")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, customerService.findByID(1));
    }

    @Test
    void findByName() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        Customer c1 = new Customer(1, "Bao", "abc", "0000", null);
        Customer c2 = new Customer(2, "Bao", "abcd", "0001", null);
        customerList.add(c1);
        customerList.add(c2);

        Mockito.when((customerService.findByName("Bao", Optional.empty(), Optional.empty()))).thenReturn(customerList);
        MvcResult mvcResult = mvc.perform(get("/admin/customers")
                .param("name", "Bao")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(customerList, customerService.findByName("Bao", Optional.empty(), Optional.empty()));
    }

    @Test
    void findByPhoneNumber() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        Customer c1 = new Customer(1, "Bao", "abc", "0000", null);
        Customer c2 = new Customer(2, "Binh", "abcd", "0000", null);
        customerList.add(c1);
        customerList.add(c2);

        Mockito.when((customerService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()))).thenReturn(customerList);
        MvcResult mvcResult = mvc.perform(get("/admin/customers")
                .param("phone_number", "0000")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(customerList, customerService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()));
    }

    @Test
    void findByAddress() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        Customer c1 = new Customer(1, "Bao", "abcd", "0000", null);
        Customer c2 = new Customer(2, "Binh", "abcd", "0001", null);
        customerList.add(c1);
        customerList.add(c2);

        Mockito.when((customerService.findByAddress("abcd", Optional.empty(), Optional.empty()))).thenReturn(customerList);
        MvcResult mvcResult = mvc.perform(get("/admin/customers")
                .param("address", "abcd")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(customerList, customerService.findByAddress("abcd", Optional.empty(), Optional.empty()));
    }
}