package es.codeurjc.shoppingCart.domain;


import java.util.Optional;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {


        private ShoppingCartRepository shoppingCartRepository;

        public ShoppingCartUseCaseImpl(ShoppingCartRepository repository){this.shoppingCartRepository = repository;}


        @Override
        public ShoppingCartDto createProduct(ShoppingCartDto shoppingCart) {
                ShoppingCartDto fullShoppingCartDto = shoppingCartRepository.save(shoppingCart);
                return fullShoppingCartDto;
        }

        @Override
        public Optional<ShoppingCartDto> findShoppingCartById(Long id) {
                return shoppingCartRepository.findShoppingCartById(id);
        }

        @Override
        public void deleteShoppingCartById(Long id) {
                shoppingCartRepository.deleteShoppingCartById(id);
        }
}
