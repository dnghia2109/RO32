package com.example.demosecurity;

import com.example.demosecurity.entity.Category;
import com.example.demosecurity.entity.Product;
import com.example.demosecurity.repository.CategoryRepository;
import com.example.demosecurity.repository.ProductRepository;
import com.example.demosecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

@SpringBootTest
class DemoSecurityApplicationTests {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void initDataProduct() {
        Product product1 = Product.builder()
                .name("Tai nghe")
                .price(450000L)
                .description("Tai nghe không dây")
                .createTime(LocalDateTime.now())
                .build();
        Product product2 = Product.builder()
                .name("Google Pixel 6")
                .price(6500000L)
                .description("Điện thoại Google Pixel")
                .createTime(LocalDateTime.now())
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    void initDataCategory() {
        Category category1 = Category.builder()
                .name("Điện thoại")
                .build();
        Category category2 = Category.builder()
                .name("Máy tinh")
                .build();
        Category category3 = Category.builder()
                .name("Phụ kiện")
                .build();
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }
}
