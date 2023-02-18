package com.example.RetailSalesSQL.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id", nullable = false)
    private Long Id;
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private int amount;

    @Column(name = "weekNo")
    private int weekNo;

    @Column(name = "points")
    private int points;


}
