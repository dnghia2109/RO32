package com.example.demojparelationship.entity.OneToMany.BidDirectional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity(name="book")
@Table(name="book")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    @JsonIgnore
    private Author author;
}
