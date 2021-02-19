package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface ShoppingCartRepository {


    FullShoppingCartDto save(FullShoppingCartDto shoppingCartDto);

    Optional<FullShoppingCartDto> findShoppingCartById(Long id);

    void deleteShoppingCartById(Long id);

}
