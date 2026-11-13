package com.libraryapi.service;

import com.libraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.libraryapi.entity.Book;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public List<String> getAllBooks(){
        return List.of(bookRepository.findAll().toString());
    }

    public String getBookById(int id) {
        return bookRepository.findById(id).toString();
    }

    public void addBook(String title, String author, int publishedYear) {
        Book book = new Book(title, author, publishedYear);
        bookRepository.save(book);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
