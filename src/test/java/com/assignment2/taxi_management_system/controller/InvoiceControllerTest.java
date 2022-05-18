package com.assignment2.taxi_management_system.controller;

import com.assignment2.taxi_management_system.model.Invoice;
import com.assignment2.taxi_management_system.service.InvoiceService;
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

@WebMvcTest(InvoiceController.class)
class InvoiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private InvoiceService invoiceService;

    @Test
    void getAllInvoices() {
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(new Invoice(1, "Bao", "abc", "0000", null));
        invoiceList.add(new Invoice(2, "Bao", "abc", "0000", null));
        invoiceList.add(new Invoice(3, "Bao", "abc", "0000", null));

        Mockito.when(invoiceService.getAllInvoices(Optional.empty(), Optional.empty())).thenReturn(invoiceList);
        MvcResult mvcResult = mvc.perform(get("/admin/invoices")
                        .param("page", "1")
                        .param("limit", "10")
                        .with(csrf()))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(invoiceList, invoiceService.getAllInvoices(Optional.empty(), Optional.empty()));
    }

    @Test
    void addInvoice() {
        Invoice bao = new Invoice(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(invoiceService.saveInvoice(bao)).thenReturn(bao);
        MvcResult mvcResult = mvc.perform(post("/admin/invoices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(bao, invoiceService.saveInvoice(bao));
    }

    @Test
    void deleteInvoice() {
        Invoice bao = new Invoice(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");

        Mockito.when(invoiceService.deleteInvoice(bao)).thenReturn(bao.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/admin/invoices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(bao.getId(), invoiceService.deleteInvoice(bao));
    }

    @Test
    void updateInvoice() {
        Invoice c1 = new Invoice(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((invoiceService.updateInvoice(c1))).thenReturn(c1.getId());
        MvcResult mvcResult = mvc.perform(put("/admin/invoices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1.getId(), invoiceService.updateInvoice(c1));
    }

    @Test
    void setDriver() {
    }

    @Test
    void setInvoice() {
    }

    @Test
    void findByInvoiceInDate() {
    }

    @Test
    void findByDriverInDate() {
    }

    @Test
    void findRevenueAll() {
        
    }

    @Test
    void findRevenueInDate() {
    }

    @Test
    void findRevenueByInvoiceInDate() {
    }

    @Test
    void findRevenueByDriverInDate() {
    }

    @Test
    void findByID() {
        Invoice c1 = new Invoice(1, "Bao", "abc", "0000", null);

        JSONObject json = new JSONObject();
        json.put("id", "1");


        Mockito.when((invoiceService.findByID(1))).thenReturn(c1);
        MvcResult mvcResult = mvc.perform(get("/admin/invoices")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json))
                .with(csrf())).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals(c1, invoiceService.findByID(1));
    }

    @Test
    void findByDate() {
    }

    @Test
    void findCarUse() {
    }
}