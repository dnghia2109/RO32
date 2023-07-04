//package com.example.demopageable;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query(value = "SELECT * FROM Product p LIMIT ?1 OFFSET ?2 ", nativeQuery = true)
//    Page<Product> getListProductPaging();
//}
