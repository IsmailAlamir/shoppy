package com.example.shoppy.Domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private BigDecimal totalCost;

}
