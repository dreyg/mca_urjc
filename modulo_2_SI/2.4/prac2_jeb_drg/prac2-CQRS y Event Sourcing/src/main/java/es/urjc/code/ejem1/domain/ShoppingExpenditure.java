package es.urjc.code.ejem1.domain;

import java.time.Instant;


public class ShoppingExpenditure {


    private Long id;
    private double price;
    private Instant timestamp = Instant.now();

    public ShoppingExpenditure() {
    }

    public ShoppingExpenditure(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
