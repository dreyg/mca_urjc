package es.codeurjc.shoppingCart.infrastructure.model;


import javax.persistence.*;

@Entity
public class CartProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    private ShoppingCartEntity shoppingCartEntity;

    @OneToOne
    private ProductEntity product;

    public CartProductEntity() {
    }

    public CartProductEntity(Long id, Integer quantity, ShoppingCartEntity shoppingCartEntity, ProductEntity product) {
        this.id = id;
        this.quantity = quantity;
        this.shoppingCartEntity = shoppingCartEntity;
        this.product = product;
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

    public ShoppingCartEntity getShoppingCartEntity() {
        return shoppingCartEntity;
    }

    public void setShoppingCartEntity(ShoppingCartEntity shoppingCartEntity) {
        this.shoppingCartEntity = shoppingCartEntity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
