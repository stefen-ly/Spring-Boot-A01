package com.example.spwmvca01a1.dto;

import java.math.BigDecimal;

public record ProductDto(
        String name,
        BigDecimal price,
        Boolean status
) {
}