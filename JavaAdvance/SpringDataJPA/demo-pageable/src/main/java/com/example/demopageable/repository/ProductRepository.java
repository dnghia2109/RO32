package com.example.demopageable.repository;

import com.example.demopageable.dto.ProductDto;
import com.example.demopageable.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query( nativeQuery = true , name = "getProductInfo")
    List<ProductDto> getProductInfo(@Param("name") String name);

    @Query(value = "SELECT * FROM Product p LIMIT ?2 OFFSET ?1",nativeQuery = true)
    List<Product> pagingWithQuery(int offset, int pageSize);
}
