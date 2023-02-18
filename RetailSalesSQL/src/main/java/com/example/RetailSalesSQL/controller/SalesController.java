package com.example.RetailSalesSQL.controller;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.repository.SalesRepository;
import com.example.RetailSalesSQL.service.Rewards;
import com.example.RetailSalesSQL.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = {"com.example.RetailSalesSQL.controller", "com.example.RetailSalesSQL.model", "com.example.RetailSalesSQL.service", "com.example.RetailSalesSQL.repository"})
public class SalesController {
    @Autowired
    private SalesService salesService;

    @PostMapping(value = "/addSales", produces = "application/json")

    @ResponseBody
    public List<Sales> postDetails(@RequestBody List<Sales> s) {
        return salesService.saveDetails(s);
    }
    @GetMapping("/totalRewards")
    public List<Rewards> getCustomerRewards(){
        return salesService.findRewardsPerCustomer();
    }
    @GetMapping("/transactions/{customerId}")
    public List<Sales> getCustomerTransactions(@PathVariable int customerId){
        return salesService.findTransactionsByCustomer(customerId);
    }
    @GetMapping("/customer/{customerId}")
    public String getCustomerPoints(@PathVariable int customerId) {
        return salesService.findPointsForCustomer(customerId);
    }

}