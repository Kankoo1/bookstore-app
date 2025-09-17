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

       public Book saveBook(Book book) {
        return bookRepository.save(book);
       }

       public void deleteBYId(Long id) {
        bookRepository.deleteById(id);
       }


       public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
       }


       public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
       }

       public Optional<Book> findBookByIsbn(String isbn) {
        return Optional.ofNullable(bookRepository.findByIsbn(isbn));
       }
}
