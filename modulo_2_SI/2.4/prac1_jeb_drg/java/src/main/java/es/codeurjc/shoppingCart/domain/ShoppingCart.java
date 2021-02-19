package es.codeurjc.shoppingCart.domain;

import java.util.Map;

public class ShoppingCart {


    private Long id;
    private String state;
    private Integer count;
    private Map<Product, Integer> products;

    public ShoppingCart() {
    }

    public ShoppingCart(String state, Integer count, Map<Product, Integer> products) {
        this.state = state;
        this.count = count;
        this.products = products;
    }
}
