package es.codeurjc.externalConsumer.dtos.requests;

import lombok.Data;

@Data
public class UserRequestDto {

    private Long id;
    private String purchaser;
    private String address;

}
