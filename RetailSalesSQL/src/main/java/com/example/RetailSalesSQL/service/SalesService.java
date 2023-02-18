package com.example.RetailSalesSQL.service;

import com.example.RetailSalesSQL.model.Sales;

import java.util.List;
import java.util.Map;

public interface SalesService {
    String findPointsForCustomer(int customerId);

    List<Sales> saveDetails(List<Sales> s);

    List<Sales> findTransactionsByCustomer(int customerId);

    List<Rewards> findRewardsPerCustomer();
}