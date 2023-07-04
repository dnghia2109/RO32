package com.example.demojparelationship.repository.OneToMany.UnDirectional;

import com.example.demojparelationship.entity.OneToMany.UnDirectional.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
