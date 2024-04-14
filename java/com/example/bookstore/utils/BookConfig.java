//package com.example.bookstore.utils;
//
//import com.example.bookstore.Model.Book;
//import com.example.bookstore.Repository.BookRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class BookConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(BookRepository repository) {
//        return args -> {
//            Book ninetyEightyFour = new Book(
//                    "1984",
//                    "George Orwell",
//                    "dystopian",
//                    "1949"
//            );
//
//            Book crimeAndPunishment = new Book(
//                    "Crime and Punishment",
//                    "Fyodor Dostoevsky",
//                    "psychological",
//                    "1866"
//            );
//
//            Book theGreatGatsby = new Book(
//                    "The Great Gatsby",
//                    "F. Scott Fitzgerald",
//                    "Fiction",
//                    "1925"
//            );
//
//            repository.saveAll(
//                    List.of(ninetyEightyFour, crimeAndPunishment, theGreatGatsby)
//            );
//        };
//    }
//}
