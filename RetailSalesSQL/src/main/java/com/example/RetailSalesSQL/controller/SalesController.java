package com.example.RetailSalesSQL.controller;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.repository.SalesRepository;
import com.example.RetailSalesSQL.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SalesController {
    @Autowired
    private SalesService salesService;

    private SalesRepository salesRepository;

    @PostMapping(value = "/addSales", produces = "application/json")

    @ResponseBody
    public List<Sales> postDetails(@RequestBody List<Sales> s) {
        return salesService.saveDetails(s);
    }

    //    GET /rewards/{customer_id},
//
//    GET /rewards/ By time period
//
//    GET Add flavor
    @GetMapping("/customer/{customerId}")
    public Map<Integer, Integer> getCustomerSales(@PathVariable int customerId) {
        return salesService.findSalesByCustomer(customerId);
    }

}