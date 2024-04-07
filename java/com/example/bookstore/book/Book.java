package com.example.bookstore.book;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;

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
    private LocalDate publish_date;
    @Transient
    private int years;

    public Book() {}
    public Book(long id, String title, String author, LocalDate date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publish_date = date;
    }

    public Book(String title, String author, LocalDate date) {
        this.title = title;
        this.author = author;
        this.publish_date = date;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }
    public int getYears() {
        return Period.between(publish_date, LocalDate.now()).getYears();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublish_date(LocalDate date) {
        this.publish_date = date;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publish_date=" + publish_date +
                ", years=" + years +
                '}';
    }
}
