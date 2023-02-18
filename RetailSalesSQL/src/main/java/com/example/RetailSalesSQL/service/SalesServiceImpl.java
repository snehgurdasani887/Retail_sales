package com.example.RetailSalesSQL.service;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.repository.SalesRepository;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    @Override
    public List<Sales> findTransactionsByCustomer(int customerId) {
        List<Sales> customer_transactions = salesRepository.findAll();
        customer_transactions = customer_transactions.stream().filter(item ->  item.getCustomerId()== customerId && item.getWeekNo()<13).collect(Collectors.toList());
        //customer_transactions = customer_transactions.stream().filter(item -> item.getWeekNo() < 13).collect(Collectors.toList());
        return customer_transactions;
    }

    @Override
    public List<Rewards> findRewardsPerCustomer() {
        List<Sales> customer_transactions = salesRepository.findAll();
        List<Integer> unique_customers = salesRepository.findUniqueCustomerIds();
        List <Sales> unique_customer_transactions = null;
        int total_points = 0;
        List<Rewards> r = new ArrayList<Rewards>();
        for(Integer i: unique_customers){
            unique_customer_transactions = customer_transactions.stream().filter(item ->  item.getCustomerId()== i).collect(Collectors.toList());
            total_points = totalPoints(unique_customer_transactions);
            r.add(new Rewards(i, total_points));
        }
        return r;
    }

    public Integer totalPoints(List<Sales> customer_sales){
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
    public List<Sales> transactionsByMonth(List<Sales> customer_sales, int startWeek, int endWeek){
        return customer_sales.stream().filter(item -> item.getWeekNo() < endWeek && item.getWeekNo() > startWeek).collect(Collectors.toList());
    }
    @Override
    public String findPointsForCustomer(int customerId){
        List<Sales> customer_sales = salesRepository.findAll();
        customer_sales = customer_sales.stream().filter(item ->  item.getCustomerId()== customerId).collect(Collectors.toList());
        List<Sales> customer_sales_month_1 = transactionsByMonth(customer_sales, 1, 5);
        List<Sales> customer_sales_month_2 = transactionsByMonth(customer_sales, 4, 9);
        List<Sales> customer_sales_month_3 = transactionsByMonth(customer_sales, 8, 13);

        Map<Integer, Integer> resultSales = new HashMap<Integer, Integer>();
        resultSales.put(1, totalPoints(customer_sales_month_1));
        resultSales.put(2, totalPoints(customer_sales_month_2));
        resultSales.put(3, totalPoints(customer_sales_month_3));

        return "customerId: " + String.valueOf(customerId) + ": {" + "1: " + resultSales.get(1).toString() + ",2: " + resultSales.get(2).toString() + ",3: " + resultSales.get(3).toString()+ ", total: " + (resultSales.get(1)+resultSales.get(2)+resultSales.get(3)) + "}";
    }

    @Override
    public List<Sales> saveDetails(List<Sales> s) {
        return salesRepository.saveAll(s);
    }
}
