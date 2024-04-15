# Bookstore

## Project description
This project is a simple backend application for a bookstore implemented using Spring Boot, with functionalities for managing books including adding, deleting, updating, and exporting/importing book data in JSON format. The project utilizes various technologies such as Spring Boot, Spring Data JPA for database interaction and Jackson for JSON serialization and deserialization.

## Classes Overview

**Book**: Represents the entity class for a book with fields like id, title, author, genre, and publish year. It uses Lombok for boilerplate code reduction and JPA annotations for persistence.

**BookDTO** (Data Transfer Object): Represents a simplified version of the Book class used for data transfer between the client and the server.

**BookMapper**: Provides methods for mapping between Book and BookDTO objects.

**BookRepository**: Extends JpaRepository for CRUD operations on the Book entity. Includes query methods for finding books by author or title.

**BookService**: Implements business logic for book-related operations such as fetching all books, adding a new book, deleting a book and updating book details. Also includes transactional methods for data consistency.

**BookController**: Defines REST endpoints for handling HTTP requests related to book operations.

## Endpoints
- GET /api/book: Retrieve all books
- POST /api/book: Add a new book
- DELETE /api/book/{bookId}: Delete a book by its ID
- PUT /api/book/{bookId}: Update a book by its ID
- GET /api/book/json/export/books: Export books to a JSON file
- POST /api/book/json/import/books: Import books from a JSON file

## Technologies used
- Spring Boot: framework for building Java-based applications
- Spring Data JPA: simplifies data access layer implementation
- PostgreSQL: relational database management system
- Hibernate: simplifies database interactions
- Lombok: library for reducing boilerplate code
- Jackson: library for JSON processing
- Maven: build automation tool for Java projects

## Summary
Through this project, I've learned how to efficiently develop backend applications using Spring Boot, implement CRUD operations with Spring Data JPA, manage RESTful endpoints and serialize/deserialize JSON data with Jackson.
