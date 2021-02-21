package es.codeurjc.shoppingCart.domain;

import java.util.List;

public class ShoppingCartDto {

    private Long id;
    private String state;
    private List <CartProductDto> cartProductDtos;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long id, String state, List<CartProductDto> cartProductDtos) {
        this.id = id;
        this.state = state;
        this.cartProductDtos = cartProductDtos;
    }

    public ShoppingCartDto(String state, List<CartProductDto> cartProductDtos) {
        this.id = null;
        this.state = state;
        this.cartProductDtos = cartProductDtos;
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

    public List<CartProductDto> getCartProductDtos() {
        return cartProductDtos;
    }

    public void setCartProductDtos(List<CartProductDto> cartProductDtos) {
        this.cartProductDtos = cartProductDtos;
    }
}
