package com.example.demojparelationship.repository.OneToMany.BiDirectional;

import com.example.demojparelationship.entity.OneToMany.BidDirectional.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
