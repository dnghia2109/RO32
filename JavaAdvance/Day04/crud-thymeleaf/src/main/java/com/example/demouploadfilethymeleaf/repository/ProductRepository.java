package com.example.demouploadfilethymeleaf.repository;

import com.example.demouploadfilethymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product create(Product product) {
        int id;
        if (products.isEmpty()) {
            id = 1;
        } else {
            Product lastProduct = products.get(products.size() - 1);
            id = lastProduct.getId() + 1;
        }
        product.setId(id);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    public Product edit(Product product) {
        var opProduct = getProductById(product.getId());
        if (opProduct.isPresent()) {
            var curProduct = opProduct.get();
            curProduct.setDetail(product.getDetail());
            curProduct.setName(product.getName());
            if (!product.getPhoto().getOriginalFilename().isEmpty()) {
                curProduct.setPhoto(product.getPhoto());
            }
            return curProduct;
        }
        return null;
    }

    public void deleteById(int id) {
        getProductById(id).ifPresent(existed -> products.remove(existed));
    }
}
