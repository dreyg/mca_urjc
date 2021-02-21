package es.codeurjc.shoppingCart.domain;

import java.util.Optional;

public interface CartProductRepository {


    CartProductDto save(CartProductDto cartProductDto);

    Optional<CartProductDto> findCartProductById(Long id);

    void deleteCartProductById(Long id);

}
