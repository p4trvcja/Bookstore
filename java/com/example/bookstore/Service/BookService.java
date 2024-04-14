package com.example.bookstore.Service;

import com.example.bookstore.Model.Book;
import com.example.bookstore.Model.BookDTO;
import com.example.bookstore.Repository.BookRepository;
import com.example.bookstore.utils.BookMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public void add(BookDTO bookDTO) {
        if(bookRepository.getBookByAuthor(bookDTO.getAuthor()).isPresent() &&
        bookRepository.getBookByTitle(bookDTO.getTitle()).isPresent())
            throw new IllegalStateException("This book is already in a database");
        else {
            Book book = new Book();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setGenre(bookDTO.getGenre());
            book.setPublish_year(bookDTO.getPublish_year());
            bookRepository.save(book);
        }
    }

    public void delete(Long id) {
        if(!bookRepository.existsById(id))
            throw new IllegalStateException("Book with id: " + id + "does not exist");
        else
            bookRepository.deleteById(id);
    }

    @Transactional
    public void update(long id, String author, String title, String genre, String year) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Book with id: " + id + "does not exist"));

        if(author != null && !Objects.equals(book.getAuthor(), author))
            book.setAuthor(author);
        if(title != null && !Objects.equals(book.getTitle(), title))
            book.setTitle(title);
        if(genre != null && !Objects.equals(book.getGenre(), genre))
            book.setGenre(genre);
        if(year != null && !Objects.equals(book.getPublish_year(), year))
            book.setPublish_year(year);

        if(bookRepository.getBookByAuthor(author).isPresent() && bookRepository.getBookByTitle(title).isPresent())
            throw new IllegalStateException("This book is already in a database");
    }


}
