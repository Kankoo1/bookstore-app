package com.norman.bookstore_backend.controller;

import com.norman.bookstore_backend.model.Book;
import com.norman.bookstore_backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService =  bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
         @PutMapping("/{id}")
          public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
            return bookService.getBookById(id)
                    .map(existingBook -> {
                        bookDetails.setId(id);
                        return ResponseEntity.ok(bookService.saveBook(bookDetails));
                    })
                    .orElse(ResponseEntity.notFound().build());
          }

          public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(book -> {
                    bookService.deleteBYId(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
          }
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/createbooks")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(value = "keyword", required = false) String keyword) {
        // Ensure keyword is never null
        String safeKeyword = (keyword != null) ? keyword.trim() : "";
        return bookService.searchBooks(safeKeyword);
    }



    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookService.findBooksByAuthor(author);
    }

}
