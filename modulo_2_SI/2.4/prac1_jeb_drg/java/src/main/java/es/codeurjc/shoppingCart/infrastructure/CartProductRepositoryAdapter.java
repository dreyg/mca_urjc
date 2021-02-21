package es.codeurjc.shoppingCart.infrastructure;

import es.codeurjc.shoppingCart.domain.*;
import es.codeurjc.shoppingCart.infrastructure.model.CartProductEntity;
import es.codeurjc.shoppingCart.infrastructure.model.CartProductEntity;
import es.codeurjc.shoppingCart.infrastructure.model.ProductEntity;
import es.codeurjc.shoppingCart.infrastructure.model.ShoppingCartEntity;
import es.codeurjc.shoppingCart.infrastructure.repository.CartProductJpaRepository;
import es.codeurjc.shoppingCart.infrastructure.repository.ShoppingCartJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;


@Component
public class CartProductRepositoryAdapter implements CartProductRepository {

    private CartProductJpaRepository cartProductJpaRepository;

    public CartProductRepositoryAdapter(CartProductJpaRepository cartProductJpaRepository){
        this.cartProductJpaRepository = cartProductJpaRepository;
    }

    @Override
    public CartProductDto save(CartProductDto cartProductDto) {
        CartProductEntity cartProductEntity = new CartProductEntity(
                cartProductDto.getId(),
                cartProductDto.getQuantity(),
                null,//cartProductDto.getShoppingCartDto(),
                null);//new ProductEntity(productDto.getName(),productDto.getDescription()));//cartProductDto.getProductDto());

        CartProductEntity savedCartProductEntity = cartProductJpaRepository.save(cartProductEntity);

        return toCarProductDto(savedCartProductEntity);

    }

    @Override
    public Optional<CartProductDto> findCartProductById(Long id) {

        Optional<CartProductEntity> maybeACartProduct = cartProductJpaRepository.findById(id);

        return maybeACartProduct.map(CartProductRepositoryAdapter::toCarProductDto);

    }

    @Override
    public void deleteCartProductById(Long id) {
        cartProductJpaRepository.deleteById(id);
    }

    private static CartProductDto toCarProductDto(CartProductEntity cartProductEntity){

        return new CartProductDto(
                cartProductEntity.getId(),
                cartProductEntity.getQuantity(),
                new ProductDto(),//()cartProductEntity.getProduct());
                new ShoppingCartDto()); //cartProductEntity.getShoppingCartEntity(),

    }
}
