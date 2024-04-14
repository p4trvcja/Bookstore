package com.example.bookstore.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BookAPI {
    @SerializedName(value = "Title")
    private String title;
    @SerializedName(value = "Author")
    private String author;
    @SerializedName(value = "Genre")
    private String genre;
    @SerializedName(value = "PublishYear")
    private String publish_year;
}
