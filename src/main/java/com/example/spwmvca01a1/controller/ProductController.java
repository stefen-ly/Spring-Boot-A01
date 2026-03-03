package com.example.spwmvca01a1.controller;

import com.example.spwmvca01a1.dto.CreateProductRequest;
import com.example.spwmvca01a1.dto.ProductResponse;
import com.example.spwmvca01a1.dto.UpdateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @GetMapping
    public List<ProductResponse> getAllProducts(
            @RequestParam(required = false,defaultValue = "0") int pageNumber,
            @RequestParam(required = false,defaultValue = "20") int pageSize
    ){
        log.info("pageNumber : {}, pageSize : {}",pageNumber,pageSize);
        return  List.of();
    }

    @PostMapping
    public void createNewProduct(@RequestBody CreateProductRequest createProductRequest){
        log.info("createProductRequest : {}",createProductRequest);
    }

    @PutMapping("/{code}")
    public ProductResponse updateProductByCode(@PathVariable String code , @RequestBody UpdateProductRequest updateProductRequest){
        log.info("updateProductByCode  : {} with new data : {}",code,updateProductRequest);
        return  null;
    }

    @PatchMapping("/{code}")
    public ProductResponse updateProductPartiallyByCode(@PathVariable String code, @RequestBody UpdateProductRequest updateProductRequest){
        log.info("updateProductPartiallyByCode  : {} with new data : {}",code,updateProductRequest);

        return null;
    }

    @DeleteMapping("/{code}")
    public void deleteProductByCode(@PathVariable String code){
        log.info("deleteProductByCode : {}",code);
    }

}
