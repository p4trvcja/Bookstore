package com.example.bookstore.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            Book ninetyEightyFour = new Book(
                    "1984",
                    "George Orwell",
                    LocalDate.of(1949, 6, 8)
            );

            Book crimeAndPunishment = new Book(
                    "Crime and Punishment",
                    "Fyodor Dostoevsky",
                    LocalDate.of(1866, 12, 1)
            );

            repository.saveAll(
                    List.of(ninetyEightyFour, crimeAndPunishment)
            );
        };
    }
}
