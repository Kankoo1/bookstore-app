package com.norman.bookstore_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Column(unique = true)
    private String isbn;

    private String publisher;

    @Column(name = "publication_date")
    private LocalDate publicationDate;
    private String language;
    private String category;
    private Integer pages;
    private Double price;

    @Column(name="stock_quantity")
     private Integer stockQuantity;

     @Column(length = 2000)
     private String description;

    //Image field (URL to cover image)
    @Column(name = "cover_image_url")
     private String coverImageUrl;

     private Double rating;

     @CreationTimestamp
     @Column(name = "created_at", nullable = false, updatable = false)
     @JsonProperty(access = JsonProperty.Access.READ_ONLY)
     private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
     private LocalDateTime updatedAt;

     public void setId(Long id) {
          this.id = id;
      }
}
