package es.codeurjc.shoppingCart.service;


import es.codeurjc.shoppingCart.controller.ShoppingCartRequestDto;
import es.codeurjc.shoppingCart.controller.ShoppingCartResponseDto;
import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ShoppingCartService {

    private ShoppingCartUseCase shoppingCartUseCase;

    public ShoppingCartService(ShoppingCartUseCase shoppingCartUseCase){this.shoppingCartUseCase = shoppingCartUseCase;}


    public ShoppingCartDto save(ShoppingCartRequestDto shoppingCartRequestDto) {

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(
                shoppingCartRequestDto.getState(),
                shoppingCartRequestDto.getCartProduct());

        return shoppingCartUseCase.createShoppingCart(shoppingCartDto);
    }


    public Optional<ShoppingCartResponseDto> findById(Long id) {
        return shoppingCartUseCase.findShoppingCartById(id).map(ShoppingCartResponseDto::fromShoppingCartDto);
    }

    public Optional<ShoppingCartDto> findByIdDto(Long id) {
        return shoppingCartUseCase.findShoppingCartById(id);
    }

    public void deleteById(Long id) {
        shoppingCartUseCase.deleteShoppingCartById(id);
    }


    public ShoppingCartDto update(ShoppingCartResponseDto shoppingCartRequestDto) {

        Random r = new Random();
        Integer aux = r.nextInt(2);

        shoppingCartRequestDto.setState((aux == 1) ? "completed" : "uncompleted");

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(
                shoppingCartRequestDto.getId(),
                shoppingCartRequestDto.getState(),
                shoppingCartRequestDto.getCartProduct());


        return shoppingCartUseCase.updateShoppingCart(shoppingCartDto);
    }


    public ShoppingCartDto saveCartProduct(CartProductDto cartProductDto, long cartId) {
        Optional<ShoppingCartDto> shoppingCartDto = this.findByIdDto(cartId);
        Optional<ShoppingCartRequestDto> shoppingCartRequestDto = shoppingCartDto.map(ShoppingCartResponseDto::fromShoppingCartDtoToRequest);

        shoppingCartRequestDto.get().getCartProduct().add(cartProductDto);
        return save(shoppingCartRequestDto.get());
    }
}
