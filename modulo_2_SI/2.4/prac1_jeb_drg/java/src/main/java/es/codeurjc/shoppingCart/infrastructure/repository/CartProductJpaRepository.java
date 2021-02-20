package es.codeurjc.shoppingCart.infrastructure.repository;

import es.codeurjc.shoppingCart.infrastructure.model.CartProductEntity;
import es.codeurjc.shoppingCart.infrastructure.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductJpaRepository extends JpaRepository<CartProductEntity, Long> {

}
