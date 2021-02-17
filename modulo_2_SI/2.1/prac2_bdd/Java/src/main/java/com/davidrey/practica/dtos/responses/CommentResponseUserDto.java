package com.davidrey.practica.dtos.responses;

import lombok.Data;

@Data
public class CommentResponseUserDto {

    private Long id;
    private String comment;
    private float score;
}
