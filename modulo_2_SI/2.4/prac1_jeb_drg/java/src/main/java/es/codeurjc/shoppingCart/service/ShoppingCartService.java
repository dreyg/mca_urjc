package es.codeurjc.shoppingCart.service;


import es.codeurjc.shoppingCart.controller.ShoppingCartRequestDto;
import es.codeurjc.shoppingCart.controller.ShoppingCartResponseDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {

    private ShoppingCartUseCase shoppingCartUseCase;

    public ShoppingCartService(ShoppingCartUseCase shoppingCartUseCase){this.shoppingCartUseCase = shoppingCartUseCase;}


    public ShoppingCartDto save(ShoppingCartRequestDto shoppingCartRequestDto) {

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(
                shoppingCartRequestDto.getState(),
                shoppingCartRequestDto.getProducts());

        return shoppingCartUseCase.createProduct(shoppingCartDto);
    }


    public Optional<ShoppingCartResponseDto> findById(Long id) {
        return shoppingCartUseCase.findShoppingCartById(id).map(ShoppingCartResponseDto::fromShoppingCartDto);
    }

    public void deleteById(Long id) {
        shoppingCartUseCase.deleteShoppingCartById(id);
    }





}
