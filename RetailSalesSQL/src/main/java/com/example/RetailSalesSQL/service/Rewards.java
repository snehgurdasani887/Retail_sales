package com.example.RetailSalesSQL.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Rewards {

    public int customerId;
    public int totalPoints;
}
