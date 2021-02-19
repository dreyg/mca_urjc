package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.FullShoppingCartDto;

import java.util.List;

public class ShoppingCartResponseDto {

    private Long id;
    private String state;
    private Integer count;
    private List<ProductRequestDto> productRequestDtoList;

    public static ShoppingCartResponseDto fromFullShoppingCartDto(FullShoppingCartDto fullShoppingCartDto){
        return new ShoppingCartResponseDto(
                fullShoppingCartDto.getId(),
            fullShoppingCartDto.getState(),
            fullShoppingCartDto.getCount(),
            fullShoppingCartDto.getProductList());
    }

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(String state, Integer count, List<ProductRequestDto> productRequestDtoList) {
        this.state = state;
        this.count = count;
        this.productRequestDtoList = productRequestDtoList;
    }

    public ShoppingCartResponseDto(Long id, String state, Integer count, List<ProductRequestDto> productRequestDtoList) {
        this.id = id;
        this.state = state;
        this.count = count;
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
