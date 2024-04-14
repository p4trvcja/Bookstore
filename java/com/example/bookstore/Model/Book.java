package com.example.bookstore.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private long id;
    private String title;
    private String author;
    private String genre;
    private String publish_year;

    public Book() {}

    public Book(String title, String author, String genre, String year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publish_year = year;
    }

    public Book(long id, String title, String author, String genre, String year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publish_year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publish_year=" + publish_year +
                '}';
    }
}
