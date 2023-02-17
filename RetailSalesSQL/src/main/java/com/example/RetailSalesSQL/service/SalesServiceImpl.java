package com.example.RetailSalesSQL.service;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{
    @Autowired
    private SalesRepository salesRepository;
    public List<Sales> findSalesById(Long id) {
        return null;
    }


    @Override
    public List<Sales> saveDetails(List<Sales> s) {
        return salesRepository.saveAll(s);
    }
}
