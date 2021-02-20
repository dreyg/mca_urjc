package es.codeurjc.shoppingCart.domain;

import java.util.Map;

public class ShoppingCartDto {

    private Long id;
    private String state;
    private Map<Product, Integer> products;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long id, String state, Map<Product, Integer> products) {
        this.id = id;
        this.state = state;
        this.products = products;
    }

    public ShoppingCartDto(String state, Map<Product, Integer> products) {
        this.id = null;
        this.state = state;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
