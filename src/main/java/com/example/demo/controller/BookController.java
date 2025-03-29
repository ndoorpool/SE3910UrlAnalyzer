package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/hello")
    public String save(){

        return "Hello World";
    }

    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public ResponseEntity<?> findBooks(){
        return new ResponseEntity<>(bookService.AllBooks(), HttpStatus.OK);
    }

}
