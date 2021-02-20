package es.codeurjc.shoppingCart.domain;

public class CartProduct {

    private Long id;
    private String quantity;
    private Product product;

    public CartProduct() {
    }

    public CartProduct(Long id, String quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }
}
