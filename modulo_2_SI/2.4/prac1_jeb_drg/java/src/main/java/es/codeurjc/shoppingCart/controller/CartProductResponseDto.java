package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.ProductDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;

public class CartProductResponseDto {


    private Long id;
    private Integer quantity;
    private ProductDto product;
    private ShoppingCartDto shoppingCart;

    public CartProductResponseDto() {
    }

    public CartProductResponseDto(Long id, Integer quantity, ProductDto product, ShoppingCartDto shoppingCart) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.shoppingCart = shoppingCart;
    }

    public static CartProductResponseDto fromCartProductDto(CartProductDto cartProductDto){
        return new CartProductResponseDto(
                cartProductDto.getId(),
                cartProductDto.getQuantity(),
                cartProductDto.getProductDto(),
                cartProductDto.getShoppingCartDto());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public ShoppingCartDto getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDto shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
