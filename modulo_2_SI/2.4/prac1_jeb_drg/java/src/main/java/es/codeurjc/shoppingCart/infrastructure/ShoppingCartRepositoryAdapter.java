package es.codeurjc.shoppingCart.infrastructure;

import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartRepository;
import es.codeurjc.shoppingCart.infrastructure.model.ShoppingCartEntity;
import es.codeurjc.shoppingCart.infrastructure.repository.ShoppingCartJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

    private ShoppingCartJpaRepository shoppingCartJpaRepository;

    public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository){
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
    }


    @Override
    public ShoppingCartDto save(ShoppingCartDto shoppingCart) {

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity(
                shoppingCart.getId(),
                shoppingCart.getState(),
                shoppingCart.getProducts());

        ShoppingCartEntity savedShoppingCartEntity = shoppingCartJpaRepository.save(shoppingCartEntity);

        return toShoppingCartDto(savedShoppingCartEntity);
    }

    @Override
    public Optional<ShoppingCartDto> findShoppingCartById(Long id) {

        Optional<ShoppingCartEntity> maybeAShoppingCart = shoppingCartJpaRepository.findById(id);

        return maybeAShoppingCart.map(ShoppingCartRepositoryAdapter::toShoppingCartDto);

    }

    @Override
    public void deleteShoppingCartById(Long id) {

        shoppingCartJpaRepository.deleteById(id);

    }



    private static ShoppingCartDto toShoppingCartDto(ShoppingCartEntity shoppingCart){

        return new ShoppingCartDto(
                shoppingCart.getId(),
                shoppingCart.getStatus(),
                shoppingCart.getProducts());

    }

}
