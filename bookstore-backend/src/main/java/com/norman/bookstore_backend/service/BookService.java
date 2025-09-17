package com.norman.bookstore_backend.service;

import com.norman.bookstore_backend.model.Book;
import com.norman.bookstore_backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

      private final BookRepository bookRepository;


    public   BookService(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
      }

      public List<Book> getAllBooks() {
        return bookRepository.findAll();
      }


      public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
      }




}
