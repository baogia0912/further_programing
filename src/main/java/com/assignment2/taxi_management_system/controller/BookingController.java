package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @RequestMapping(path = "/bookings", method = RequestMethod.GET)
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @RequestMapping(path = "/bookings", method = RequestMethod.POST)
    public Long addBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    @RequestMapping(path = "/bookings", method = RequestMethod.DELETE)
    public Long deleteBooking(@RequestBody Booking booking){
        return bookingService.deleteBooking(booking);
    }

    @RequestMapping(path = "/bookings", method = RequestMethod.PUT)
    public Long updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }
}