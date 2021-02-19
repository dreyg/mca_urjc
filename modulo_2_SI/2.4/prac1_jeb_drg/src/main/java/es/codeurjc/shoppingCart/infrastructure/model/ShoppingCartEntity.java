package es.codeurjc.shoppingCart.infrastructure.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "STATUS")
    private String status;

    @Column(columnDefinition = "COUNT")
    private String count;

    //TODO ojo aqui el mapeo, revisar

    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productEntities;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(Long id, String status, String count, List<ProductEntity> productEntities) {
        this.id = id;
        this.status = status;
        this.count = count;
        this.productEntities = productEntities;
    }

    public ShoppingCartEntity(String status, String count, List<ProductEntity> productEntities) {
        this.id = null;
        this.status = status;
        this.count = count;
        this.productEntities = productEntities;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", count='" + count + '\'' +
                ", productEntities=" + productEntities +
                '}';
    }
}
