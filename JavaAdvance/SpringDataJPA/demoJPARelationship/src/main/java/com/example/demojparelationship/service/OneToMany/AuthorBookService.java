package com.example.demojparelationship.service.OneToMany;

import com.example.demojparelationship.entity.OneToMany.BidDirectional.Author;
import com.example.demojparelationship.entity.OneToMany.BidDirectional.Book;
import com.example.demojparelationship.repository.OneToMany.BiDirectional.AuthorRepo;
import com.example.demojparelationship.repository.OneToMany.BiDirectional.BookRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorBookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    //    @Transactional
//    public void generateAuthorBook(){
//        Author joan = new Author("Joana","Thriller",45);
//        Author jim = new Author("Jim","Commedy",50);
//        Book book1 = new Book("Adventure", UUID.randomUUID().toString());
//
//        Book book2 = new Book("Discovery",UUID.randomUUID().toString());
//
//        Book book3 = new Book("Smile at once",UUID.randomUUID().toString());
//
//        Book book4 = new Book("Dancing",UUID.randomUUID().toString());
//        joan.addBook(book1);joan.addBook(book2);
//        jim.addBook(book3);jim.addBook(book4);
//        em.persist(joan);
//        em.persist(jim);
//
//    }
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public List<Book> getAllBooksByAuthor(String authorName) {
        return bookRepo.findBookByAuthor_Name1(authorName);
    }
}
