package com.example.spwmvca01a1.repository;

import com.example.spwmvca01a1.domain.OrderLine;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
}
