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

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SalesController {
    @Autowired
    private SalesService salesService;

    private SalesRepository salesRepository;

    @PostMapping("/addSales")

    @ResponseBody
    public List<Sales> postDetails(@RequestBody List<Sales> s){
        return salesService.saveDetails(s);
    }

    @GetMapping(value = "/{id}")
    public String getPoints(@PathVariable("id") Long id, Model m){

        long month_points = 0L;
        long total_points = 0L;
        m.addAttribute("customer_id", id);
        m.addAttribute("month", month_points);
        m.addAttribute("total_points", total_points);
        return "result";
    }
}