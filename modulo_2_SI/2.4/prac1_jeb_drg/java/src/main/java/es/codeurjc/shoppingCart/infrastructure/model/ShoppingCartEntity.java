package es.codeurjc.shoppingCart.infrastructure.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToMany(mappedBy="shoppingCartEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProductEntity> cartProducts;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(Long id, String status, List<CartProductEntity> cartProducts) {
        this.id = id;
        this.status = status;
        this.cartProducts = cartProducts;
    }

    public ShoppingCartEntity(String status, List<CartProductEntity> cartProducts) {
        this.id = null;
        this.status = status;
        this.cartProducts = cartProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CartProductEntity> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProductEntity> cartProducts) {
        this.cartProducts = cartProducts;
    }


}
