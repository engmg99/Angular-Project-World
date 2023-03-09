package com.projectworld.ProjectWorld.controller;

import com.projectworld.ProjectWorld.entity.Book;
import com.projectworld.ProjectWorld.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookstore/")
public class BookController {
// rror in delete by Id check that
    @Autowired
    private Book book1;

    @Autowired
    private BookService bookservice;

    @GetMapping("/books")
    public Book getBooks() {
        book1.setName("Harry Potter");
        book1.setAuthor("JK Rowling");
        return book1;
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookservice.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/getBooks/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId) {
        System.out.println("-------------->" + bookservice.getBookById(bookId));
        Book b = bookservice.getBookById(bookId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book bookData) {
        String response = bookservice.addBook(bookData);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> bookDeleted(@PathVariable("id") Long bookId) {
        String response = bookservice.deleteBook(bookId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book bookReceived) {
        Book b = bookservice.updateBook(bookReceived);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}

