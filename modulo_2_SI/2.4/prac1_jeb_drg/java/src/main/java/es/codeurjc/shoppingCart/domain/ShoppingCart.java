package es.codeurjc.shoppingCart.domain;

import java.util.Map;

public class ShoppingCart {


    private Long id;
    private String state;
    private Map<Product, Integer> products;

    public ShoppingCart() {
    }

    public ShoppingCart(String state, Map<Product, Integer> products) {
        this.state = state;
        this.products = products;
    }
}
