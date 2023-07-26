package com.example.demopageable.entity;


import com.example.demopageable.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(
    name = "ProductInfo",
    classes = @ConstructorResult(
        targetClass = ProductDto.class,
        columns = {
                @ColumnResult(name = "name"),
                @ColumnResult(name = "price")
        }
    )
)
@NamedNativeQuery(
        name = "getProductInfo",
        resultSetMapping = "ProductInfo",
        query = "SELECT p.name, p.price " +
                "FROM product p " +
                "WHERE p.name like CONCAT('%',:name,'%') "
)


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Integer quantity;
    private long price;
}
