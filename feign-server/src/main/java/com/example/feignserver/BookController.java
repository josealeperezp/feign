package com.example.feignserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @GetMapping(value ="/book")
    public ResponseEntity<List<String>> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("book1");
        books.add("book2");
        books.add("book3");
        return ResponseEntity.ok(books);
    }
}
