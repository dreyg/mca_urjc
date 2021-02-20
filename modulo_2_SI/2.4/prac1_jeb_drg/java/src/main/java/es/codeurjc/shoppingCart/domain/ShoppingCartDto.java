package es.codeurjc.shoppingCart.domain;

import java.util.List;

public class ShoppingCartDto {

    private Long id;
    private String state;
    private List<CartProductDto> products;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long id, String state, List<CartProductDto> products) {
        this.id = id;
        this.state = state;
        this.products = products;
    }

    public ShoppingCartDto(Long id, String status) {
        this.id = id;
        this.state = state;
    }

    public ShoppingCartDto(String state, List<CartProductDto> products) {
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
