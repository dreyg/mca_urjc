package es.urjc.code.ejem1.domain;

import java.math.BigDecimal;


public class ShoppingExpenditureDTO {


    private Long id;
    private double price;

    public ShoppingExpenditureDTO() {
    }

    public ShoppingExpenditureDTO(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
