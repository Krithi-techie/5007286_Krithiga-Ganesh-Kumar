package com.example.bookstoreapi.model;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class Book {
    @NotNull
    private Long id;

    @Size(min = 1, max = 255)
    private String title;

    @NotNull
    private String author;

    @Min(1)
    private Double price;

    private String isbn;
}
