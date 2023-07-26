package com.example.demosecurity.repository;

import com.example.demosecurity.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p order by p.price DESC")
    List<Product> findByOrderByPriceDesc(Pageable pageable);
    @Query("select p from Product p where p.id = ?1")
    Product findDetailProduct();

}
