package com.example.demospringweb;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Component
public class BookRepository {
    public List<Book> createLisstBooks() {
        return List.of(
                        new Book(1L, "Sách 1", "Lại Duy Nghĩa"),
                        new Book(2L, "Tat den", "Ngo Tat To"),
                        new Book(3L, "Harry Potter", "JK Rowling")
                );
    }



}
