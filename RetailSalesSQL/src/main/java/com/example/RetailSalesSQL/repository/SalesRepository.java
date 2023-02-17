package com.example.RetailSalesSQL.repository;

import com.example.RetailSalesSQL.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {}
