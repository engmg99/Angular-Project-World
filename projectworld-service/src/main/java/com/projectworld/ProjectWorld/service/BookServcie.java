package com.projectworld.ProjectWorld.service;

import java.util.List;

import com.projectworld.ProjectWorld.entity.Book;

public interface BookServcie {
	public List<Book> getBooks();

	public Book getBookById(Long id);

	public String addBook(Book b);

	public String deleteBook(Long id);

	public Book updateBook(Book b);
}
