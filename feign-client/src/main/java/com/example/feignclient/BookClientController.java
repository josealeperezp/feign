package com.example.feignclient;

import com.example.feignclient.client.BookClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookClientController {

    BookClient bookClient;

    public BookClientController(BookClient bookClient) {
        this.bookClient = bookClient;
    }
    @GetMapping(value = "/client/book")
    public ResponseEntity<List<String>> getBooks() {
        return ResponseEntity.ok(bookClient.getBooks());
    }
}
