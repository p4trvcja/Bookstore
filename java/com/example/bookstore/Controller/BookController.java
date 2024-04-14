package com.example.bookstore.Controller;

import com.example.bookstore.Model.BookDTO;
import com.example.bookstore.Service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private final BookService bookService;
    private final ObjectMapper objectMapper;

    @Autowired
    public BookController(BookService bookService, ObjectMapper objectMapper) {
        this.bookService = bookService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void add(@RequestBody BookDTO bookDTO) {
        bookService.add(bookDTO);
    }

    @DeleteMapping(path = "{bookId}")
    public void delete(@PathVariable("bookId") Long id) {
        bookService.delete(id);
    }

    @PutMapping(path="{bookId}")
    public void update(
            @PathVariable("bookId") Long id,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String year
            ) {
        bookService.update(id, author, title, genre, year);
    }

    @GetMapping("/json/export/books")
    public ResponseEntity<Resource> exportBooksToJson() throws Exception {
        try {
            List<BookDTO> books = bookService.getBooks();
            String jsonData = objectMapper.writeValueAsString(books);
            ByteArrayResource resource = new ByteArrayResource(jsonData.getBytes());

            String fileName = "books_" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".json";
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(resource);
        } catch (Exception e) {
            throw new Exception("Exporting Books JSON Failed, Due to: " + e.getMessage());
        }
    }

    @PostMapping("/json/import/books")
    public ResponseEntity<String> importBooks(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            String jsonContent = new String(file.getBytes());
            List<BookDTO> books = objectMapper.readValue(jsonContent, new TypeReference<List<BookDTO>>() {});
            for (BookDTO book : books) {
                bookService.add(book);
            }
            return ResponseEntity.ok().body("Books imported successfully.");
        } catch (Exception e) {
            throw new Exception("Importing Books JSON Failed, Due to: " + e.getMessage());
        }
    }
}
