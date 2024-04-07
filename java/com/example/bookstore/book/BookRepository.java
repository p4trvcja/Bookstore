package com.example.bookstore.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.author=?1")
    Optional<Book> getBookByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.title=?1")
    Optional<Book> getBookByTitle(String title);
}
