package com.example.demojparelationship.repository.OneToMany.BiDirectional;

import com.example.demojparelationship.entity.OneToMany.BidDirectional.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findBookByAuthor_Name(String authorName);

//    @Query(value = "SELECT *\n" +
//            "FROM book b\n" +
//            "LEFT JOIN author a ON b.`author_id` = a.`id`\n" +
//            "WHERE a.name = ?1", nativeQuery = true)
    @Query("SELECT b.title, b.\n" +
            "FROM book b\n" +
            "LEFT JOIN author a ON b.author.id = a.id \n" +
            "WHERE a.name LIKE ?1 ")
    List<Book> findBookByAuthor_Name1(String authorName);
}
