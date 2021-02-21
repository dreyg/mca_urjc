package es.codeurjc.shoppingCart.domain;

public class CartProduct {

    private Long id;
    private String quantity;
    private Product product;
    private ShoppingCart shoppingCart;

    public CartProduct() {
    }

    public CartProduct(String quantity, Product product, ShoppingCart shoppingCart) {
        this.quantity = quantity;
        this.product = product;
        this.shoppingCart = shoppingCart;
    }
}
