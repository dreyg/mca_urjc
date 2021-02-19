package es.codeurjc.shoppingCart.domain;

import java.util.List;

public class ShoppingCartDto {

    private String state;
    private Integer count;
    private List<ProductDto> productList;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(String state, Integer count, List<ProductDto> productList) {
        this.state = state;
        this.count = count;
        this.productList = productList;
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

    public List<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDto> productList) {
        this.productList = productList;
    }


}
