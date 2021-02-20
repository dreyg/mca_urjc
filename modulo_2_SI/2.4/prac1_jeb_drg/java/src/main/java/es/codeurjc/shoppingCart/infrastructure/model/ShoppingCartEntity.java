package es.codeurjc.shoppingCart.infrastructure.model;

import es.codeurjc.shoppingCart.domain.CartProductDto;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToMany(mappedBy="shoppingCartEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProductEntity> cartProducts;



}
