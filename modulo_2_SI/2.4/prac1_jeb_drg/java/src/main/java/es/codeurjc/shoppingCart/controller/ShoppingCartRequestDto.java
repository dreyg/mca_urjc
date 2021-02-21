package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.CartProductDto;

import java.util.List;

public class ShoppingCartRequestDto {


    private Long id;
    private String state;
    private List <CartProductDto> cartProduct;

    public ShoppingCartRequestDto() {
    }

    public ShoppingCartRequestDto(Long id, String state, List<CartProductDto> cartProduct) {
        this.id = id;
        this.state = state;
        this.cartProduct = cartProduct;
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

    public List<CartProductDto> getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(List<CartProductDto> cartProduct) {
        this.cartProduct = cartProduct;
    }
}
