package com.example.spwmvca01a1.repository;

import com.example.spwmvca01a1.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
