package es.codeurjc.shoppingCart.domain;

public class CartProductDto {

    private Long id;
    private String quantity;
    private ProductDto productDto;
    private ShoppingCartDto shoppingCartDto;

    public CartProductDto() {
    }

    public CartProductDto(Long id, String quantity, ProductDto productDto, ShoppingCartDto shoppingCartDto) {
        this.id = id;
        this.quantity = quantity;
        this.productDto = productDto;
        this.shoppingCartDto = shoppingCartDto;
    }

    public CartProductDto(String quantity, ProductDto productDto, ShoppingCartDto shoppingCartDto) {
        this.id = null;
        this.quantity = quantity;
        this.productDto = productDto;
        this.shoppingCartDto = shoppingCartDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public ShoppingCartDto getShoppingCartDto() {
        return shoppingCartDto;
    }

    public void setShoppingCartDto(ShoppingCartDto shoppingCartDto) {
        this.shoppingCartDto = shoppingCartDto;
    }
}
