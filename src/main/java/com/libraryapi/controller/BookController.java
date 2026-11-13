package com.libraryapi.controller;


import com.libraryapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<String> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping
    public String getBookById(@RequestParam int id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody String title, String author, int publishedYear){
        bookService.addBook(title, author, publishedYear);
    }

    @DeleteMapping
    public void deleteById(@RequestBody int id){
        bookService.deleteById(id);
    }
}
