package com.example.spwmvca01a1.service;

import com.example.spwmvca01a1.dto.CreateProductRequest;
import com.example.spwmvca01a1.dto.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {

    // Define ur logic here
    Page<ProductResponse> getAll(int pageNumber, int pageSize);

    ProductResponse createNew(CreateProductRequest createProductRequest);
}
