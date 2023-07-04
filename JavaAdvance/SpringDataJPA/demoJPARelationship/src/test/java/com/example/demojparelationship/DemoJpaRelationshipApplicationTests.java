package com.example.demojparelationship;

import com.example.demojparelationship.entity.OneToMany.BidDirectional.Author;
import com.example.demojparelationship.entity.OneToMany.BidDirectional.Book;
import com.example.demojparelationship.repository.OneToMany.BiDirectional.AuthorRepo;
import com.example.demojparelationship.repository.OneToMany.BiDirectional.BookRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class DemoJpaRelationshipApplicationTests {


    @Autowired
    private BookRepo bookRepo;



    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AuthorRepo authorRepo;

    @Test
    void initDataAuthorBook() {
        Author joan = new Author("Joana","Thriller",45);
        Author jim = new Author("Jim","Comedy",50);
        Author nghia = new Author("Nghia","Action",22);
        Author messi = new Author("Messi","Romance",36);
        Author ronaldo = new Author("Ronaldo","Comedy",38);

        Book book1 = new Book("Adventure", UUID.randomUUID().toString());
        Book book2 = new Book("Discovery",UUID.randomUUID().toString());
        Book book3 = new Book("Smile at once",UUID.randomUUID().toString());
        Book book4 = new Book("Dancing",UUID.randomUUID().toString());
        Book book5 = new Book("Book5",UUID.randomUUID().toString());
        Book book6 = new Book("Book6",UUID.randomUUID().toString());
        Book book7 = new Book("Book7",UUID.randomUUID().toString());
        Book book8 = new Book("Book8",UUID.randomUUID().toString());
        Book book9 = new Book("Book9",UUID.randomUUID().toString());
        Book book10 = new Book("Book10",UUID.randomUUID().toString());

        joan.addBook(book1);
        joan.addBook(book2);
        jim.addBook(book3);
        jim.addBook(book4);
        nghia.addBook(book5);
        nghia.addBook(book6);
        messi.addBook(book7);
        messi.addBook(book8);
        ronaldo.addBook(book9);
        ronaldo.addBook(book10);
        authorRepo.save(joan);
        authorRepo.save(jim);
        authorRepo.save(nghia);
        authorRepo.save(messi);
        authorRepo.save(ronaldo);
    }

}
