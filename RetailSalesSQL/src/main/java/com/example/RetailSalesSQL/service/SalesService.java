package com.example.RetailSalesSQL.service;

import com.example.RetailSalesSQL.model.Sales;

import java.util.List;
import java.util.Map;

public interface SalesService {
    Map<Integer, Integer> findSalesByCustomer(int customerId);


    List<Sales> saveDetails(List<Sales> s);

}