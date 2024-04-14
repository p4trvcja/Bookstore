package com.example.bookstore.utils;

import com.example.bookstore.Model.Book;
import com.example.bookstore.Model.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public static BookDTO mapToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .publish_year(book.getPublish_year())
                .build();
    }

    public static Book mapToBook(BookDTO bookDTO) {
        return Book.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .genre(bookDTO.getGenre())
                .publish_year(bookDTO.getPublish_year())
                .build();
    }
}