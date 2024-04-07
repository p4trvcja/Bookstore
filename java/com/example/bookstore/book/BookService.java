package com.example.bookstore.book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        if(bookRepository.getBookByAuthor(book.getAuthor()).isPresent() &&
        bookRepository.getBookByTitle(book.getTitle()).isPresent())
            throw new IllegalStateException("This book is already in a database");
        else
            bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if(!bookRepository.existsById(id))
            throw new IllegalStateException("Book with id: " + id + "does not exist");
        else
            bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(long id, String author, String title, String date) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Book with id: " + id + "does not exist"));

        if(author != null && !Objects.equals(book.getAuthor(), author))
            book.setAuthor(author);
        if(title != null && !Objects.equals(book.getTitle(), title))
            book.setTitle(title);

        String[] d = new String[2];
        if(date != null)
            d = date.split("-");
        if(date != null && !Objects.equals(book.getPublish_date(), LocalDate.of(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]))))
            book.setPublish_date(LocalDate.of(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])));

        if(bookRepository.getBookByAuthor(author).isPresent() && bookRepository.getBookByTitle(title).isPresent())
            throw new IllegalStateException("This book is already in a database");
    }
}
