package es.codeurjc.shoppingCart.controller;

import java.util.List;

public class ShoppingCartRequestDto {


    private String state;
    private Integer count;
    private List<ProductRequestDto> productRequestDtoList;


    public ShoppingCartRequestDto() {
    }

    public ShoppingCartRequestDto(String state, String count, List<ProductRequestDto> productRequestDtoList) {
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
