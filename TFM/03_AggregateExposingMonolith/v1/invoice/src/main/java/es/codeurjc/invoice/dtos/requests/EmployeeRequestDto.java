package es.codeurjc.invoice.dtos.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmployeeRequestDto {

    @NotBlank(message = "Loyalty number is mandatory")
    private String loyaltyCardNumber;

}
