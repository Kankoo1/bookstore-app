package com.norman.bookstore_backend.service;
import com.norman.bookstore_backend.model.Book;
import com.norman.bookstore_backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {
      private final BookRepository bookRepository;

    public   BookService(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
      }

      public List<Book> getAllBooks() {
          List<Book> books = bookRepository.findAll();
          System.out.println("Books fetched from DB: " + books.size());
          return books;
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


       public List<Book> findBooksByTitle(String title) { return bookRepository.findByTitleContainingIgnoreCase(title);}
       public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
       }

       public Optional<Book> findBookByIsbn(String isbn) {return Optional.ofNullable(bookRepository.findByIsbn(isbn));}
    public List<Book> saveBooks(List<Book> books) {return bookRepository.saveAll(books);}

    public List<Book> searchBooks(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            // Return empty list if no keyword is provided
            return new ArrayList<>();
        }

        String trimmedKeyword = keyword.trim();
        return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrIsbnContainingIgnoreCase(
                trimmedKeyword, trimmedKeyword, trimmedKeyword, trimmedKeyword);
    }

}
