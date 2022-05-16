package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @RequestMapping(path = "/admin/bookings", method = RequestMethod.GET)
    public List<Booking> getAllBookings(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                        @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return bookingService.getAllBookings(page, limit);
    }

    @RequestMapping(path = {"/admin/bookings","/customer/bookings"}, method = RequestMethod.POST)
    public Long addBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    @RequestMapping(path = {"/admin/bookings", "/customer/bookings"}, method = RequestMethod.DELETE)
    public Long deleteBooking(@RequestBody Booking booking){
        return bookingService.deleteBooking(booking);
    }

    @RequestMapping(path = {"/admin/bookings","/customer/bookings"}, method = RequestMethod.PUT)
    public Long updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @RequestMapping(path = {"/admin/bookings","/customer/bookings"}, method = RequestMethod.GET, params = "id")
    public Booking findByID(@RequestParam("id") long id){
        return bookingService.findByID(id);
    }

    @RequestMapping(path = {"/admin/bookings", "/customer/bookings"}, method = RequestMethod.GET, params = {"start_date", "end_date"})
    public List<Booking> findByDate(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                    @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date,
                                    @RequestParam(value = "page", required = false) Optional<Integer> page,
                                    @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return bookingService.findByDate(start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()),
                page,
                limit);
    }
}