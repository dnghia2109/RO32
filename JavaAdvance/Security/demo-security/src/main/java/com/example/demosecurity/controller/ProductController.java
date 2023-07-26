package com.example.demosecurity.controller;

import com.example.demosecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/san-pham")
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/san-pham/{id}")
    public String getDetailProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "update-product";
    }

}
