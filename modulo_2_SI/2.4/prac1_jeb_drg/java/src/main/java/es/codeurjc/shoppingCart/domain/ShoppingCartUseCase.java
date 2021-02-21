package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface ShoppingCartUseCase {


    public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCart);

    public Optional<ShoppingCartDto> findShoppingCartById(Long id);

    public void deleteShoppingCartById(Long id);

    public ShoppingCartDto updateShoppingCart(ShoppingCartDto shoppingCart);

}
