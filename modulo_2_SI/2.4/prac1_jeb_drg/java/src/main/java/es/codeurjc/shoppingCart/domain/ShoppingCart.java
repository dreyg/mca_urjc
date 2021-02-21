package es.codeurjc.shoppingCart.domain;

import java.util.List;

public class ShoppingCart {

    private Long id;
    private String state;
    private List <CartProduct> cartProducts;

    public ShoppingCart() {
    }

    public ShoppingCart(String state, List<CartProduct> cartProducts) {
        this.state = state;
        this.cartProducts = cartProducts;
    }

}
