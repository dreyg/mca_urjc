package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface ShoppingCartUseCase {


    public FullShoppingCartDto createProduct(ShoppingCartDto shoppingCart);

    public Optional<FullShoppingCartDto> findShoppingCartById(Long id);

    public void deleteShoppingCartById(Long id);

    // TODO añadir las funciones q faltan, revisar.

}
