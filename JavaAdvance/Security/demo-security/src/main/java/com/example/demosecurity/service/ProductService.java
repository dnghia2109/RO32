package com.example.demosecurity.service;

import com.example.demosecurity.entity.Product;
import com.example.demosecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            return null;
        }
        return productRepository.findById(id).get();
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product productRequest) {
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .createTime(LocalDateTime.now())
                .price(productRequest.getPrice())
                .build();
        return productRepository.save(newProduct);
    }

    public Product updateProduct(Long id, Product productRequest) {
        Product product = getProductById(id);
        if (product == null) {
            throw new RuntimeException("Không tim thấy sản phẩm có id-" + id);
        }
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
