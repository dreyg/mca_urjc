package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;

import java.util.List;

public class ShoppingCartResponseDto {


    private Long id;
    private String state;
    private List<CartProductDto> products;

    public static ShoppingCartResponseDto fromShoppingCartDto(ShoppingCartDto shoppingCartDto){
        return new ShoppingCartResponseDto(
                shoppingCartDto.getId(),
            shoppingCartDto.getState(),
            shoppingCartDto.getProducts());
    }

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(Long id, String state, List<CartProductDto> products) {
        this.id = id;
        this.state = state;
        this.products = products;
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

    public List<CartProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<CartProductDto> products) {
        this.products = products;
    }
}
