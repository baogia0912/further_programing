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
@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @RequestMapping(path = "/invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.POST)
    public Long addInvoice(@RequestBody Invoice invoice){
        return invoiceService.saveInvoice(invoice);
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.DELETE)
    public Long deleteInvoice(@RequestBody Invoice invoice){
        return invoiceService.deleteInvoice(invoice);
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.PUT)
    public Long updateInvoice(@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(invoice);
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.GET, params = "id")
    public Invoice findByID(@RequestParam("id") long id){
        return invoiceService.findByID(id);
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.GET, params = {"start_date", "end_date"})
    public List<Invoice> findByDate(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date, @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date){
        return invoiceService.findByDate(start_date.toInstant().atZone(ZoneId.systemDefault()), end_date.toInstant().atZone(ZoneId.systemDefault()));
    }
}