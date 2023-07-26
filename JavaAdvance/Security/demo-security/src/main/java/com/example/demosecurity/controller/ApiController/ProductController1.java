package com.example.demosecurity.controller.ApiController;

import com.example.demosecurity.entity.Product;
import com.example.demosecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController1 {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/add-product")
    public ResponseEntity<?> createProduct(@RequestParam Product productRequest) {
        return ResponseEntity.ok().body(productService.saveProduct(productRequest));
    }
}
