package es.urjc.code.ejem1.controller;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCartExpenditureResponseDTO {

    @JsonProperty("cartId") private Long id;
    @JsonProperty("expenditure") private double price;

    public ShoppingCartExpenditureResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
