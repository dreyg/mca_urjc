package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.Product;

import java.util.List;
import java.util.Map;

public class ShoppingCartRequestDto {


    private String state;
    private List<CartProductDto> products;

    public ShoppingCartRequestDto() {
    }

    public ShoppingCartRequestDto(String state, List<CartProductDto> products) {
        this.state = state;
        this.products = products;
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
