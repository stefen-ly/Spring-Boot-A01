package com.example.spwmvca01a1.service;

import com.example.spwmvca01a1.domain.Category;
import com.example.spwmvca01a1.domain.Product;
import com.example.spwmvca01a1.dto.CreateProductRequest;
import com.example.spwmvca01a1.dto.ProductResponse;
import com.example.spwmvca01a1.repository.CategoryRepository;
import com.example.spwmvca01a1.repository.ProductRepository;
import com.example.spwmvca01a1.utils.RandomUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Page<ProductResponse> getAll(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return productRepository.findAll(pageable)
                .map(product -> ProductResponse.builder()
                        .code(product.getCode())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .picture(product.getPicture())
                        .isAvailable(product.getIsAvailable())
                        .build());
    }


    @Override
    public ProductResponse createNew(CreateProductRequest createProductRequest) {
        // TODO
        // Validate category ID
        Category category = categoryRepository
                .findById(Integer.valueOf(createProductRequest.categoryId()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Category ID not found"));

        // Transfer data from DTO to Entity
        Product product = new Product();
        product.setName(createProductRequest.name());
        product.setDescription(createProductRequest.description());
        product.setPrice(createProductRequest.price());
        product.setPicture(createProductRequest.picture());
        product.setCategory(category);

        // Set generated data
        product.setCode(RandomUtil.generateProductCode());
        product.setIsAvailable(true);

        // Save data into database
        productRepository.save(product);

        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .picture(product.getPicture())
                .isAvailable(product.getIsAvailable())
                .build();
    }

}