package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface ShoppingCartRepository {


    ShoppingCartDto save(ShoppingCartDto shoppingCartDto);

    Optional<ShoppingCartDto> findShoppingCartById(Long id);

    void deleteShoppingCartById(Long id);

    ShoppingCartDto update(ShoppingCartDto shoppingCartDto);

}
