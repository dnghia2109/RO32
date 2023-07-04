package com.example.demojparelationship.controller.OneToMany;

import com.example.demojparelationship.service.OneToMany.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
public class AuthorBookController {

    @Autowired
    private AuthorBookService authorBookService;

    @GetMapping("/find-by-author")
    public ResponseEntity<?> findBookByAuthor(@RequestParam String authorName) {
        return ResponseEntity.ok().body(authorBookService.getAllBooksByAuthor(authorName));
    }
}
