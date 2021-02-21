package es.codeurjc.shoppingCart.service;


import es.codeurjc.shoppingCart.controller.CartProductRequestDto;
import es.codeurjc.shoppingCart.controller.CartProductResponseDto;
import es.codeurjc.shoppingCart.controller.ShoppingCartResponseDto;
import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.CartProductUseCase;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductService {

    private CartProductUseCase cartProductUseCase;

    public CartProductService(CartProductUseCase cartProductUseCase){this.cartProductUseCase = cartProductUseCase;}


    public CartProductDto save(CartProductRequestDto cartProductRequestDto) {

        CartProductDto cartProductDto = new CartProductDto(
                cartProductRequestDto.getQuantity(),
                cartProductRequestDto.getProduct(),
                cartProductRequestDto.getShoppingCart());

        return cartProductUseCase.createCartProduct(cartProductDto);
    }


    public Optional<CartProductResponseDto> findById(Long id) {
        return cartProductUseCase.findCartProductById(id).map(CartProductResponseDto::fromCartProductDto);
    }

    public Optional<CartProductDto> findByIdDto(Long id) {
        return cartProductUseCase.findCartProductById(id);
    }

    public void deleteById(Long id) {
        cartProductUseCase.deleteCartProductById(id);
    }







}
