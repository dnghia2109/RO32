package com.example.demopageable.controller;

import com.example.demopageable.repository.ProductRepository;
import com.example.demopageable.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<?>getDetailProduct(@RequestParam String name) {
        return ResponseEntity.ok().body(productRepository.getProductInfo(name));
    }

    @GetMapping("/paging-sort")
    public ResponseEntity<?> findProductsWithPaginationAndSorting(@RequestParam String field, @RequestParam int offset,
                                                                    @RequestParam int pageSize)  {
        return ResponseEntity.ok().body(productService.findProductsWithPaginationAndSorting(offset, pageSize, field));
    }
  }
