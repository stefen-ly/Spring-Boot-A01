package com.example.spwmvca01a1.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
        String code,
        String name,
        BigDecimal price
) {
}
