package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Driver;
import com.assignment2.taxi_management_system.service.DriverService;
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

@WebMvcTest(DriverController.class)
class DriverControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DriverService driverService;

    @Test
    void getAllDrivers() throws Exception {
        List<Driver> driverList = new ArrayList<>();
        driverList.add(new Driver(1L, "Bao", "1234", "4321",4.9,null));
        driverList.add(new Driver(2L, "Bao", "1234", "4321",4.9,null));
        driverList.add(new Driver(3L,  "Bao", "1234", "4321",4.9,null));

        Mockito.when(driverService.getAllDrivers(Optional.empty(), Optional.empty())).thenReturn(driverList);
        MvcResult mvcResult = mvc.perform(get("/admin/drivers")
                        .param("page", "1")
                        .param("limit", "10")
                        .with(csrf()))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(driverList, driverService.getAllDrivers(Optional.empty(), Optional.empty()));
    }

    @Test
    void addDriver() throws Exception {
        Driver driver = new Driver(1L, "Bao", "1234", "4321",4.9,null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(driverService.saveDriver(driver)).thenReturn(driver.getId());
        MvcResult mvcResult = mvc.perform(post("/admin/drivers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(driver.getId(), driverService.saveDriver(driver));
    }

    @Test
    void deleteDriver() throws Exception {
        Driver driver = new Driver(1L, "Bao", "1234", "4321",4.9,null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(driverService.deleteDriver(driver)).thenReturn(driver.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/admin/drivers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(driver.getId(), driverService.deleteDriver(driver));
    }

    @Test
    void updateDriver() throws Exception {
        Driver c1 = new Driver(1L, "Bao", "1234", "4321",4.9,null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((driverService.updateDriver(c1))).thenReturn(c1.getId());
        MvcResult mvcResult = mvc.perform(put("/admin/drivers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1.getId(), driverService.updateDriver(c1));
    }

    @Test
    void findByID() throws Exception {
        Driver c1 = new Driver(1L, "Bao", "1234", "4321",4.9,null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((driverService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/drivers")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, driverService.findByID(1));
    }

    @Test
    void findByName() throws Exception {
        List<Driver> driverList = new ArrayList<>();
        Driver c1 = new Driver(1L, "Bao", "1234", "4321",4.9,null);
        Driver c2 = new Driver(2L, "Bao", "1234", "4321",4.9,null);
        driverList.add(c1);
        driverList.add(c2);

        Mockito.when((driverService.findByName("Bao", Optional.empty(), Optional.empty()))).thenReturn(driverList);
        MvcResult mvcResult = mvc.perform(get("/admin/drivers")
                .param("name", "Bao")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(driverList, driverService.findByName("Bao", Optional.empty(), Optional.empty()));
    }

    @Test
    void findByLicenseNumber() throws Exception {

        List<Driver> driverList = new ArrayList<>();
        Driver c1 = new Driver(1L, "Bao", "1234", "4321",4.9,null);
        Driver c2 = new Driver(2L, "Bao", "1234", "4321",4.9,null);
        driverList.add(c1);
        driverList.add(c2);

        Mockito.when((driverService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()))).thenReturn(driverList);
        MvcResult mvcResult = mvc.perform(get("/admin/drivers")
                .param("phone_number", "0000")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(driverList, driverService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()));
    }

    @Test
    void findByPhoneNumber() throws Exception {
        List<Driver> driverList = new ArrayList<>();
        Driver c1 = new Driver(1L, "Bao", "1234", "4321",4.9,null);
        Driver c2 = new Driver(2L, "Bao", "1234", "4321",4.9,null);
        driverList.add(c1);
        driverList.add(c2);

        Mockito.when((driverService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()))).thenReturn(driverList);
        MvcResult mvcResult = mvc.perform(get("/admin/drivers")
                .param("phone_number", "0000")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(driverList, driverService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()));
    }

    @Test
    void findByRating() throws Exception {
        List<Driver> driverList = new ArrayList<>();
        Driver c1 = new Driver(1L, "Bao", "1234", "4321",4.9,null);
        Driver c2 = new Driver(2L, "Bao", "1234", "4321",4.9,null);
        driverList.add(c1);
        driverList.add(c2);

        Mockito.when((driverService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()))).thenReturn(driverList);
        MvcResult mvcResult = mvc.perform(get("/admin/drivers")
                .param("phone_number", "0000")
                .param("page", "1")
                .param("limit", "10")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(driverList, driverService.findByPhoneNumber("0000", Optional.empty(), Optional.empty()));
    }
}