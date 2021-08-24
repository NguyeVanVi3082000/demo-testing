package com.example.demotesting.service;

import com.example.demotesting.domain.Book;
import com.example.demotesting.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> findAll()
    {
        return bookRepo.findAll();
    }
    public Book saveBook(Book book) {
        Book save = bookRepo.save(book);
        return save;
    }
}
