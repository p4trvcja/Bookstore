package com.example.bookstore.Model;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDTO {
    private transient long id;

    private String title;
    private String author;
    private String genre;
    private String publish_year;

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private long id;
        private String title;
        private String author;
        private String genre;
        private String publish_year;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder publish_year(String year) {
            this.publish_year = year;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookDTO build() {
            if(title.isEmpty())
                    throw new IllegalStateException("Title cannot be empty");
            if(author.isEmpty())
                    throw new IllegalStateException("Author cannot be empty");

            BookDTO bookDTO = new BookDTO();
            bookDTO.id = this.id;
            bookDTO.title = this.title;
            bookDTO.author = this.author;
            bookDTO.genre = this.genre;
            bookDTO.publish_year = this.publish_year;
            return bookDTO;
        }
    }
}
