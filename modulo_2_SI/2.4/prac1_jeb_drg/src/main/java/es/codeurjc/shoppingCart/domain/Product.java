package es.codeurjc.shoppingCart.domain;

public class Product {

    private Long id;
    private String name;
    private String description;

    public Product() {
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
