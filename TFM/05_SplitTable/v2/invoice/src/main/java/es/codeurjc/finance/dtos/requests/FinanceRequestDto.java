package es.codeurjc.finance.dtos.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FinanceRequestDto {

    @NotBlank(message = "Customer Id number is mandatory")
    private String name;

}
