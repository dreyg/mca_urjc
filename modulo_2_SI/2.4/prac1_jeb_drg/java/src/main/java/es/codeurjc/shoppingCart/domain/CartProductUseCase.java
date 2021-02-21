package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface CartProductUseCase {


    public CartProductDto createCartProduct(CartProductDto cartProduct);

    public Optional<CartProductDto> findCartProductById(Long id);

    public void deleteCartProductById(Long id);

    // TODO añadir las funciones q faltan, revisar.

}
