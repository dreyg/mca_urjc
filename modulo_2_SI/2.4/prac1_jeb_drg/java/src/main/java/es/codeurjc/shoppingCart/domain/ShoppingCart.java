package es.codeurjc.shoppingCart.domain;

import java.util.List;
import java.util.Map;

public class ShoppingCart {


    private Long id;
    private String state;
    private List <CartProductDto> products;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, String state, List<CartProductDto> products) {
        this.id = id;
        this.state = state;
        this.products = products;
    }
}
