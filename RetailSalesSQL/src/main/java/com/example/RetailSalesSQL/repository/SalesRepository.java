package com.example.RetailSalesSQL.repository;

import com.example.RetailSalesSQL.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findByCustomerId(Long customerId);
//
//    List<Laptop> findByBrand(String name);
//
//    List<Laptop> findByPrice(BigDecimal price);

}
