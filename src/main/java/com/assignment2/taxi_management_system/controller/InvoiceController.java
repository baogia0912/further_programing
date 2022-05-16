package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.model.Invoice;
import com.assignment2.taxi_management_system.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @RequestMapping(path = "/admin/invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                        @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return invoiceService.getAllInvoices(page, limit);
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.POST)
    public Long addInvoice(@RequestBody Invoice invoice){
        return invoiceService.saveInvoice(invoice);
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.DELETE)
    public Long deleteInvoice(@RequestBody Invoice invoice){
        return invoiceService.deleteInvoice(invoice);
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.PUT)
    public Long updateInvoice(@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(invoice);
    }

    @RequestMapping(path ="admin/invoice", method = RequestMethod.PATCH)
    public Long setDriver(@RequestBody Invoice invoice){
        return invoiceService.setDriver(invoice);
    }

    @RequestMapping(path ="admin/invoice", method = RequestMethod.PATCH)
    public Long setCustomer(@RequestBody Invoice invoice){
        return invoiceService.setCustomer(invoice);
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.GET, params = {"customer_id", "start_date", "end_date"})
    public List<Invoice> findByCustomerInDate(@RequestParam("customer") long customer_id,
                                              @RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                              @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date,
                                              @RequestParam(value = "page", required = false) Optional<Integer> page,
                                              @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return invoiceService.findByCustomerInDate(customer_id,
                start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()),
                page,
                limit);
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.GET, params = {"driver_id", "start_date", "end_date"})
    public List<Invoice> findByDriverInDate(@RequestParam("driver") long driver_id,
                                            @RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                            @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date,
                                            @RequestParam(value = "page", required = false) Optional<Integer> page,
                                            @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return invoiceService.findByDriverInDate(driver_id,
                start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()),
                page,
                limit);
    }

    @RequestMapping(path = "/admin/invoices/revenue", method = RequestMethod.GET)
    public double findRevenueAll() {
        return invoiceService.findRevenueAll();
    }

    @RequestMapping(path = "//admininvoices/revenue", method = RequestMethod.GET, params = {"start_date", "end_date"})
    public double findRevenueInDate(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                    @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date) {
        return invoiceService.findRevenueInDate(start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()));
    }

    @RequestMapping(path = "/admin/invoices/revenue", method = RequestMethod.GET, params = {"customer_id", "start_date", "end_date"})
    public double findRevenueByCustomerInDate(@RequestParam("customer_id") long customer_id,
                                              @RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                              @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date) {
        return invoiceService.findRevenueByCustomerInDate(customer_id,
                start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()));
    }

    @RequestMapping(path = "/admin/invoices/revenue", method = RequestMethod.GET, params = {"driver_id", "start_date", "end_date"})
    public double findRevenueByDriverInDate(@RequestParam("driver_id") long driver_id,
                                            @RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                            @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date) {
        return invoiceService.findRevenueByDriverInDate(driver_id,
                start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()));
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.GET, params = "id")
    public Invoice findByID(@RequestParam("id") long id){
        return invoiceService.findByID(id);
    }

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.GET, params = {"start_date", "end_date"})
    public List<Invoice> findByDate(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
                                    @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date,
                                    @RequestParam(value = "page", required = false) Optional<Integer> page,
                                    @RequestParam(value = "limit", required = false) Optional<Integer> limit){
        return invoiceService.findByDate(start_date.toInstant().atZone(ZoneId.systemDefault()),
                end_date.toInstant().atZone(ZoneId.systemDefault()),
                page,
                limit);
    }

    @RequestMapping(path = "admin/invoices/car", method = RequestMethod.GET, params = {"car_id", "start_date"})
    public double findCarUse(@RequestParam("car_id") long car_id,
                             @RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM") Date start_date){
        return invoiceService.findNumberOfUseInAMonth(car_id,
                start_date.toInstant().atZone(ZoneId.systemDefault()));
    }
}