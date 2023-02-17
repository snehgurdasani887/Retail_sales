package com.example.RetailSalesSQL.service;

import com.example.RetailSalesSQL.model.Sales;

import java.util.List;

public interface SalesService {
    public List<Sales> findSalesById(Long id);

    List<Sales> saveDetails(List<Sales> s);
}