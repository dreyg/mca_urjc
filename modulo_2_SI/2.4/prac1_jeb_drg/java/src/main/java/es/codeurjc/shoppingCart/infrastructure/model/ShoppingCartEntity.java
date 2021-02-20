package es.codeurjc.shoppingCart.infrastructure.model;

import javax.persistence.*;
import java.util.Map;

@Entity
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "STATUS")
    private String status;

    //TODO ojo aqui el mapeo, revisar

    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<ProductEntity, Integer> products;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(Long id, String status, Map<ProductEntity, Integer> products) {
        this.id = id;
        this.status = status;
        this.products = products;
    }

    public ShoppingCartEntity(String status, Map<ProductEntity, Integer> products) {
        this.id = null;
        this.status = status;
        this.products = products;
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

    public Map<ProductEntity, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductEntity, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", products=" + products +
                '}';
    }
}
