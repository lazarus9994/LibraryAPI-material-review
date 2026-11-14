package com.libraryapi.controller;


import com.libraryapi.entity.Book;
import com.libraryapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<String> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book.getTitle(), book.getAuthor(), book.getPublishedYear());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        bookService.deleteById(id);
    }
}
