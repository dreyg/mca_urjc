package es.codeurjc.shoppingCart.domain;


import java.util.Optional;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {


        private ShoppingCartRepository shoppingCartRepository;

        public ShoppingCartUseCaseImpl(ShoppingCartRepository repository){this.shoppingCartRepository = repository;}


        @Override
        public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCart) {
                ShoppingCartDto shoppingCartDto = shoppingCartRepository.save(shoppingCart);
                return shoppingCartDto;
        }

        @Override
        public Optional<ShoppingCartDto> findShoppingCartById(Long id) {
                return shoppingCartRepository.findShoppingCartById(id);
        }

        @Override
        public void deleteShoppingCartById(Long id) {
                shoppingCartRepository.deleteShoppingCartById(id);
        }

        @Override
        public ShoppingCartDto updateShoppingCart(ShoppingCartDto shoppingCart) {
                ShoppingCartDto shoppingCartDto = shoppingCartRepository.update(shoppingCart);
                return shoppingCartDto;
        }


}
