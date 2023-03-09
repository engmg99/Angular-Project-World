package com.projectworld.ProjectWorld.repo;

import com.projectworld.ProjectWorld.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BookRepo extends CrudRepository<Book, Long> {
    Optional<Book> findById(Long id);
}
