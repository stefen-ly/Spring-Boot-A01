package com.example.spwmvca01a1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//1. Make class to be POJO (Plain Old Java Object)
@Getter
@Setter
@NoArgsConstructor
//2. Make class to be JPA Entity
@Entity
@Table(name = "categories")
public class Category {
    @Id
    private String id;
    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}