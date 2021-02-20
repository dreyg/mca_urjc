package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface ShoppingCartUseCase {


    public ShoppingCartDto createProduct(ShoppingCartDto shoppingCart);

    public Optional<ShoppingCartDto> findShoppingCartById(Long id);

    public void deleteShoppingCartById(Long id);

    // TODO añadir las funciones q faltan, revisar.

}
