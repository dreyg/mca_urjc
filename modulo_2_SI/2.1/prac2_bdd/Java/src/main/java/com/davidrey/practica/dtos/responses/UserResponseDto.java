package com.davidrey.practica.dtos.responses;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    private String nick;
    private String mail;
    private List<CommentResponseUserDto> comments;

}
