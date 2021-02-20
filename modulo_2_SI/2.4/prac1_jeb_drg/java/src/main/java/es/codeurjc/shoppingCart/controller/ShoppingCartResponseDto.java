package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.ShoppingCartDto;

import java.util.List;

public class ShoppingCartResponseDto {

    private Long id;
    private String state;
    private Integer count;
    private List<ProductRequestDto> productRequestDtoList;

    public static ShoppingCartResponseDto fromShoppingCartDto(ShoppingCartDto shoppingCartDto){
        return new ShoppingCartResponseDto(
                shoppingCartDto.getId(),
            shoppingCartDto.getState(),
            shoppingCartDto.getProducts());
    }

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(String state, List<ProductRequestDto> productRequestDtoList) {
        this.id = null;
        this.state = state;
        this.productRequestDtoList = productRequestDtoList;
    }

    public ShoppingCartResponseDto(Long id, String state, List<ProductRequestDto> productRequestDtoList) {
        this.id = id;
        this.state = state;
        this.productRequestDtoList = productRequestDtoList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductRequestDto> getProductRequestDtoList() {
        return productRequestDtoList;
    }

    public void setProductRequestDtoList(List<ProductRequestDto> productRequestDtoList) {
        this.productRequestDtoList = productRequestDtoList;
    }
}
