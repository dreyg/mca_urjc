package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.Product;

import java.util.Map;

public class ShoppingCartRequestDto {


    private String state;
    private Map<Product, Integer> products;

    public ShoppingCartRequestDto() {
    }

    public ShoppingCartRequestDto(String state, Map<Product, Integer> products) {
        this.state = state;
        this.products = products;
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
