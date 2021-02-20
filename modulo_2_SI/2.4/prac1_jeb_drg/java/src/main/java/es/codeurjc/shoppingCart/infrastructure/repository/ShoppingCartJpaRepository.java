package es.codeurjc.shoppingCart.infrastructure.repository;

import es.codeurjc.shoppingCart.infrastructure.model.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Long> {

}
