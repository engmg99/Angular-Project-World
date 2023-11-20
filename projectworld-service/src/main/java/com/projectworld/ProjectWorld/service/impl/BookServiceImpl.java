package com.projectworld.ProjectWorld.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;

import com.projectworld.ProjectWorld.entity.Book;
import com.projectworld.ProjectWorld.exceptions.BookNotFoundException;
import com.projectworld.ProjectWorld.repo.BookRepo;
import com.projectworld.ProjectWorld.service.BookServcie;

@Service
public class BookServiceImpl implements BookServcie {
	// private static List<Book> list = new ArrayList<Book>();
//
//	static {
//		list.add(new Book(2, "JavaSciprt Theory", "XYZ"));
//		list.add(new Book(3, "Java Theory", "ABC"));
//		list.add(new Book(4, "JavaSciprt Implementation", "GHT"));
//	}
	@Autowired
	private BookRepo bookRepo;

	public List<Book> getBooks() {
		List<Book> bList = (List<Book>) bookRepo.findAll();
		return bList;
	}

	public Book getBookById(Long id) {
//        Book book = null;
//		book = list.stream().filter(e->e.getId()==id).findFirst().get();
//		list.forEach(n -> {
//	        if (n.getId()==id)
//	            book=n;
//	    });
		// book = bookRepo.findById(id);
		return bookRepo.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book of id " + id + " was not found"));
	}

	public String addBook(Book b) {
//		list.add(b);
		b.setBookCode(UUID.randomUUID().toString());
		bookRepo.save(b);
		return "Book added successfully.";
	}

	public String deleteBook(Long id) {
//		Book book=null;
//		book = list.stream().filter(e->e.getId()==id).findFirst().get();
//		list.remove(book);
		bookRepo.deleteById(id);
		return "Book deleted successfully.";
	}

	public Book updateBook(Book b) {
		Book book = null;
//		book = list.stream().filter(e->e.getId()==id).findFirst().get();
//		book.setName(b.getName());
//		book.setAuthor(b.getAuthor());
		book = bookRepo.save(b);
		return book;
	}
}
