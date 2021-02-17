package com.davidrey.practica.dtos.responses;

import lombok.Data;

import java.util.List;

@Data
public class BookDetailsResponseDto {

    private Long id;
    private String title;
    private String summary;
    private String author;
    private String publisher;
    private int publicationYear;
    private float score;
    private List<CommentResponseDto> comments;

}
