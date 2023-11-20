package com.projectworld.ProjectWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectworld.ProjectWorld.entity.Book;
import com.projectworld.ProjectWorld.service.impl.BookServiceImpl;

@RestController
@RequestMapping(value = "/bookstore/")
public class BookController {
// Error in delete by Id check that
	@Autowired
	private Book book1;

	@Autowired
	private BookServiceImpl bookservice;

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

//	@RequestMapping(value = "/addBook", method = RequestMethod.POST) OR
	@PostMapping(value = "/addBook")
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
