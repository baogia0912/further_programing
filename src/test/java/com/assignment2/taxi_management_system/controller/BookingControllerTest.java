package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.service.BookingService;
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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookingService bookingService;


    @Test
    void getAllBookings() throws Exception {
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking(1L, null, null, null, null, 12, null));
        bookingList.add(new Booking(2L, null, null, null, null, 13, null));
        bookingList.add(new Booking(3L, null, null, null, null, 14, null));

        Mockito.when(bookingService.getAllBookings(Optional.empty(), Optional.empty())).thenReturn(bookingList);
        MvcResult mvcResult = mvc.perform(get("/admin/bookings")
                        .param("page", "1")
                        .param("limit", "10")
                        .with(csrf()))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(bookingList, bookingService.getAllBookings(Optional.empty(), Optional.empty()));
    }

    @Test
    void addBooking() throws Exception {
        Booking book = new Booking(1L, null, null, null, null, 12, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(bookingService.saveBooking(book)).thenReturn(book.getId());
        MvcResult mvcResult = mvc.perform(post("/admin/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(book.getId(), bookingService.saveBooking(book));
    }

    @Test
    void deleteBooking() throws Exception {
        Booking book = new Booking(1L, null, null, null, null, 12, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(bookingService.deleteBooking(book)).thenReturn(book.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/admin/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(book.getId(),bookingService.deleteBooking(book));
    }

    @Test
    void updateBooking() throws Exception {
        Booking book = new Booking(1L, null, null, null, null, 12, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((bookingService.updateBooking(book))).thenReturn(book.getId());
        MvcResult mvcResult = mvc.perform(put("/admin/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(book.getId(), bookingService.updateBooking(book));
    }

    @Test
    void findByID() throws Exception {
        Booking book = new Booking(1L, null, null, null, null, 12, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((bookingService.findByID(1))).thenReturn(book);
        MvcResult mvcResult = mvc.perform(get("/admin/bookings")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(book, bookingService.findByID(1));
    }

    @Test
    void setInvoice() {
        
    }

    @Test
    void findByDate() throws Exception {
        Booking book = new Booking(1L, null, null, null, null, 12, null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((bookingService.findByID(1))).thenReturn(book);
        MvcResult mvcResult = mvc.perform(get("/admin/bookings")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(book, bookingService.findByID(1));
    }
}