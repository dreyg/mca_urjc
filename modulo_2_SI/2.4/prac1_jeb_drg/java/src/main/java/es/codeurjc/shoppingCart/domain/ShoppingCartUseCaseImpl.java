package es.codeurjc.shoppingCart.domain;


import java.util.Optional;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {


        private ShoppingCartRepository shoppingCartRepository;

        public ShoppingCartUseCaseImpl(ShoppingCartRepository repository){this.shoppingCartRepository = repository;}


        @Override
        public FullShoppingCartDto createProduct(ShoppingCartDto shoppingCart) {
                FullShoppingCartDto shoppingCar = new FullProductDto(shoppingCart.getState(), shoppingCart.getCount(), shoppingCart.getProductList());

                FullShoppingCartDto fullShoppingCartDto = shoppingCartRepository.save(shoppingCar);
                return fullShoppingCartDto;
        }

        @Override
        public Optional<FullShoppingCartDto> findShoppingCartById(Long id) {
                return shoppingCartRepository.findShoppingCartById(id);
        }

        @Override
        public void deleteShoppingCartById(Long id) {
                shoppingCartRepository.deleteShoppingCartById(id);
        }
}
