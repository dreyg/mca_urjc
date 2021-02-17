package com.davidrey.practica.dtos.responses;

import com.davidrey.practica.models.Comment;
import lombok.Data;

import java.util.List;

@Data
public class BookResponseDto {

    private Long id;
    private String title;
    private List<Comment> comments;

}
