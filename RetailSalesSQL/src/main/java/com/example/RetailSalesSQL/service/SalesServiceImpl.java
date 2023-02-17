package com.example.RetailSalesSQL.service;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService{
    @Autowired
    private SalesRepository salesRepository;
    public List<Sales> findSalesById(Long id) {
        return null;
    }

    public Integer totalPointsByMonth(List<Sales> customer_sales){
        int points = 0;
        int total_points = 0;
        for(int i = 0; i < customer_sales.size();i++){
            if (customer_sales.get(i).getAmount() > 100){
                points += (customer_sales.get(i).getAmount() - 100)*2 + 1;
            }
            if (customer_sales.get(i).getAmount() > 50){
                points += 1;
            }
            total_points += points;
            points = 0;
        }
        return total_points;
    }
    @Override
    public Map<Integer, Integer> findSalesByCustomer(int customerId){
        List<Sales> customer_sales = salesRepository.findAll();
        customer_sales = customer_sales.stream().filter(item ->  item.getCustomerId()== customerId).collect(Collectors.toList());
        List<Sales> customer_sales_month_1 = customer_sales.stream().filter(item -> item.getWeekNo() < 5 && item.getWeekNo() > 1).collect(Collectors.toList());
        List<Sales> customer_sales_month_2 = customer_sales.stream().filter(item -> item.getWeekNo() < 9 && item.getWeekNo() > 4).collect(Collectors.toList());
        List<Sales> customer_sales_month_3 = customer_sales.stream().filter(item -> item.getWeekNo() < 13 && item.getWeekNo() > 8).collect(Collectors.toList());
        // logic - per month analysis - customer_id, total_points

        Map<Integer, Integer> resultSales = new HashMap<Integer, Integer>();
        resultSales.put(1, totalPointsByMonth(customer_sales_month_1));
        resultSales.put(2, totalPointsByMonth(customer_sales_month_2));
        resultSales.put(3, totalPointsByMonth(customer_sales_month_3));


        return resultSales;
    }

    @Override
    public List<Sales> saveDetails(List<Sales> s) {
        return salesRepository.saveAll(s);
    }
}
