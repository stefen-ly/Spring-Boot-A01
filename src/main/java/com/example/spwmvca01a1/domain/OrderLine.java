package com.example.spwmvca01a1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "order_lines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Associate mapping with order
    @ManyToOne
    private Order order;

    // Associate mapping with product
    @ManyToOne
    private Product product;

    private Integer qty;
    private BigDecimal unitPrice;
    private Float discount;
}