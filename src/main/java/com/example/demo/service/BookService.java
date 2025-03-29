package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    @Transactional
    public Book create(Book book){

        return bookRepository.save(book);
    }

    @Transactional
    public List<Book> AllBooks() {
        return bookRepository.findAll();
    }

}
