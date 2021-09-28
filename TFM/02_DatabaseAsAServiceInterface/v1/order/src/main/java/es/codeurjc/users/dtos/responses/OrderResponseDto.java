package es.codeurjc.users.dtos.responses;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponseDto {

    private Long id;
    private Date dateOrder;
    private String purchaser;
    private String address;
    private String totalPrice;


}
