package es.codeurjc.externalConsumer.dtos.responses;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String purchaser;
    private String address;

}
