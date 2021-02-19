package es.codeurjc.shoppingCart.infrastructure;

import es.codeurjc.shoppingCart.domain.FullShoppingCartDto;
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
    public FullShoppingCartDto save(FullShoppingCartDto shoppingCart) {

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity(
                shoppingCart.getId(),
                shoppingCart.getState(),
                shoppingCart.getCount(),
                shoppingCart.getProductList());

        ShoppingCartEntity savedShoppingCartEntity = shoppingCartJpaRepository.save(shoppingCartEntity);

        return toFullShoppingCartDto(savedShoppingCartEntity);
    }

    @Override
    public Optional<FullShoppingCartDto> findShoppingCartById(Long id) {

        Optional<ShoppingCartEntity> maybeAShoppingCart = shoppingCartJpaRepository.findById(id);

        return maybeAShoppingCart.map(ShoppingCartRepositoryAdapter::toFullShoppingCartDto);

    }

    @Override
    public void deleteShoppingCartById(Long id) {

        shoppingCartJpaRepository.deleteById(id);

    }



    private static FullShoppingCartDto toFullShoppingCartDto(ShoppingCartEntity shoppingCart){

        return new FullShoppingCartDto(
                shoppingCart.getId(),
                shoppingCart.getStatus(),
                shoppingCart.getCount(),
                shoppingCart.getProducts());

    }

}
