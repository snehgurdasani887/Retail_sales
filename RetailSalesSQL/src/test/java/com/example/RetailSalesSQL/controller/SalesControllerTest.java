package com.example.RetailSalesSQL.controller;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.service.Rewards;
import com.example.RetailSalesSQL.service.SalesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SalesControllerTest {
    @Mock
    private SalesService salesService;

    @InjectMocks
    private SalesController salesController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private List<Sales> buildSales(){
        return Arrays.asList(
                Sales.builder().Id(1L).category("TEST").
                        weekNo(2).points(20).amount(1000).customerId(1).build());
    }

    @Test
    public void testPostDetails(){
        List<Sales> expectedSales = buildSales();
        Mockito.when(salesService.saveDetails(Mockito.anyList())).thenReturn(expectedSales);
        List<Sales> result = salesController.postDetails(expectedSales);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.get(0).getId(), 1L);
        Assertions.assertEquals(result.get(0).getCategory(), "TEST");
        Assertions.assertEquals(result.get(0).getWeekNo(), 2);
        Assertions.assertEquals(result.get(0).getPoints(), 20);
        Assertions.assertEquals(result.get(0).getAmount(), 1000);
        Assertions.assertEquals(result.get(0).getCustomerId(), 1);
    }
    private List<Rewards> buildRewards() {
        return Arrays.asList(Rewards.builder().customerId(1).totalPoints(100).build(), Rewards.builder().customerId(2).totalPoints(200).build());
    }

    @Test
    public void testGetCustomerRewards(){
        List<Rewards> expectedRewards = buildRewards();
        Mockito.when(salesService.findRewardsPerCustomer()).thenReturn(expectedRewards);
        List<Rewards> rewards = salesController.getCustomerRewards();
        Assertions.assertNotNull(rewards);
        Assertions.assertEquals(rewards.get(0).getCustomerId(), 1);
        Assertions.assertEquals(rewards.get(0).getTotalPoints(), 100);
    }

    @Test
    public void testGetCustomerTransactions(){
        List<Sales> expectedSales = buildSales();
        Mockito.when(salesService.findTransactionsByCustomer(Mockito.anyInt())).thenReturn(expectedSales);
        List<Sales> transactions = salesController.getCustomerTransactions(1);
        Assertions.assertNotNull(transactions);
        Assertions.assertEquals(transactions.get(0).getId(), 1L);
        Assertions.assertEquals(transactions.get(0).getCategory(), "TEST");
        Assertions.assertEquals(transactions.get(0).getWeekNo(), 2);
        Assertions.assertEquals(transactions.get(0).getPoints(), 20);
        Assertions.assertEquals(transactions.get(0).getAmount(), 1000);
        Assertions.assertEquals(transactions.get(0).getCustomerId(), 1);
    }

    @Test
    public void testGetCustomerPoints() {
        Mockito.when(salesService.findPointsForCustomer(Mockito.anyInt())).thenReturn("2500");
        String totalPoints = salesController.getCustomerPoints(1);
        Assertions.assertNotNull(totalPoints);
        Assertions.assertEquals(totalPoints, "2500");
    }
}

