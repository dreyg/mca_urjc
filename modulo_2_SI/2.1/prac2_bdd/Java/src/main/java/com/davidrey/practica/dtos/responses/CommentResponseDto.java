package com.davidrey.practica.dtos.responses;

import lombok.Data;

@Data
public class CommentResponseDto {

    private Long id;
    private UserResponseDto user;
    private String comment;
    private float score;

}
