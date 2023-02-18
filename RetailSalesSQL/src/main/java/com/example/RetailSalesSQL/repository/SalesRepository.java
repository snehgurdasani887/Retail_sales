package com.example.RetailSalesSQL.repository;

import com.example.RetailSalesSQL.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    @Query("SELECT DISTINCT s.customerId FROM Sales AS s")
    List<Integer> findUniqueCustomerIds();


}
