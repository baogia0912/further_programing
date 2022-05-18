package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.service.CarService;
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

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService carService;

    @Test
    void getAllCars() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null));
        carList.add(new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null));
        carList.add(new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null));

        Mockito.when(carService.getAllCars(Optional.empty(), Optional.empty())).thenReturn(carList);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                        .param("page", "1")
                        .param("limit", "10")
                        .with(csrf()))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(carList, carService.getAllCars(Optional.empty(), Optional.empty()));
    }

    @Test
    void getAllCarsWithDrivers() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null));
        carList.add(new Car(2, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null));
        carList.add(new Car(3, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null));

        Mockito.when(carService.getAllCars(Optional.empty(), Optional.empty())).thenReturn(carList);
        MvcResult mvcResult = mvc.perform(get("/customer/cars")
                        .param("page", "1")
                        .param("limit", "10")
                        .with(csrf()))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(carList, carService.getAllCars(Optional.empty(), Optional.empty()));
    }

    @Test
    void addCar() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(carService.saveCar(c1)).thenReturn(c1.getId());
        MvcResult mvcResult = mvc.perform(post("/admin/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(c1.getId(), carService.saveCar(c1));
    }

    @Test
    void deleteCar() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(carService.deleteCar(c1)).thenReturn(c1.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/admin/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(c1.getId(), carService.deleteCar(c1));
    }

    @Test
    void updateCar() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.updateCar(c1))).thenReturn(c1.getId());
        MvcResult mvcResult = mvc.perform(put("/admin/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1.getId(), carService.updateCar(c1));
    }

    @Test
    void setDriver() {
    }

    @Test
    void findByID() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByVIN() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByMake() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByModel() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByColor() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByConvertible() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByRate() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByRating() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByID(1));
    }

    @Test
    void findByLicensePlate() throws Exception {
        Car c1 = new Car(1, "abcd", "abcd", "abcd", "red",true, 4.9, "abcd", 1.0, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((carService.findByLicensePlate("abcd"))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/cars")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, carService.findByLicensePlate("abcd"));
    }
}