package com.norman.bookstore_backend.repository;


import com.norman.bookstore_backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorIgnoreCase(String author);

    List<Book> findByCategoryIgnoreCase(String category);

    Book findByIsbn(String isbn);
}
