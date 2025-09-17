package com.norman.bookstore_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Column(unique = true)
    private String isbn;

    private String publisher;

    private LocalDate publicationDate;
    private String language;
    private String Category;
    private Integer pages;
    private Double price;
     private Integer stockQuantity;

     @Column(length = 2000)
     private String description;

    //Image field (URL to cover image)
     private String coverImageUrl;

     private Double rating;

     @CreationTimestamp
     private LocalDateTime createdAt;

     private LocalDateTime updatedAt;
}
