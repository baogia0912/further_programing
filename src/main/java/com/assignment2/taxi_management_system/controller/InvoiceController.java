package com.assignment2.taxi_management_system.controller;
import com.assignment2.taxi_management_system.model.Invoice;
import com.assignment2.taxi_management_system.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(path = "/admin/invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
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
}