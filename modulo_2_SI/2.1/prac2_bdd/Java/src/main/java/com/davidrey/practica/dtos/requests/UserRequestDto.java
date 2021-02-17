package com.davidrey.practica.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Nick is mandatory")
    private String nick;
    private String mail;

}
