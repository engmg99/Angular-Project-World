package com.projectworld.ProjectWorld.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projectworld.ProjectWorld.entity.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
	Optional<Book> findById(Long id);
}
