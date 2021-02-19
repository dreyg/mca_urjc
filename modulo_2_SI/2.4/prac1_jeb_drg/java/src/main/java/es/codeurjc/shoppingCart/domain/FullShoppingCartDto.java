package es.codeurjc.shoppingCart.domain;

import java.util.List;

public class FullShoppingCartDto {

    private Long id;
    private String state;
    private Integer count;
    private List<FullProductDto> productList;


    public static FullShoppingCartDto fromShoppingCartDto(ShoppingCartDto shoppingCart){
        return new FullShoppingCartDto(
                shoppingCart.getState(),
                shoppingCart.getCount(),
                shoppingCart.getProductList());
    }

    public FullShoppingCartDto() {
    }

    public FullShoppingCartDto(String state, Integer count, List<FullProductDto> fullProductDtos) {
        this.id = null;
        this.state = state;
        this.count = count;
        this.productList = fullProductDtos;
    }


    public FullShoppingCartDto(Long id, String state, Integer count, List<FullProductDto> fullProductDtos) {
        this.id = id;
        this.state = state;
        this.count = count;
        this.productList = fullProductDtos;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FullProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<FullProductDto> productList) {
        this.productList = productList;
    }
}
