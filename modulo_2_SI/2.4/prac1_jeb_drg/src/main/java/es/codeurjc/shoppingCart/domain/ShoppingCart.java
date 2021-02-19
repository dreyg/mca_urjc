package es.codeurjc.shoppingCart.domain;

import java.util.List;

public class ShoppingCart {


    private Long id;
    private String state;
    private Integer count;
    private List<Product> productList;

    public ShoppingCart() {
    }

    public ShoppingCart(String state, Integer count, List<Product> productList) {
        this.state = state;
        this.count = count;
        this.productList = productList;
    }
}
