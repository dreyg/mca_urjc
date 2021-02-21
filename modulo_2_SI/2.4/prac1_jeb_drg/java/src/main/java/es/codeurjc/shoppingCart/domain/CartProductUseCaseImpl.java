package es.codeurjc.shoppingCart.domain;


import java.util.Optional;

public class CartProductUseCaseImpl implements CartProductUseCase {

        private CartProductRepository cartProductRepository;

        public CartProductUseCaseImpl(CartProductRepository repository){this.cartProductRepository = repository;}

        @Override
        public CartProductDto createCartProduct(CartProductDto cartProduct) {
                CartProductDto cartProductDto = cartProductRepository.save(cartProduct);
                return cartProductDto;
        }

        @Override
        public Optional<CartProductDto> findCartProductById(Long id) {
                return cartProductRepository.findCartProductById(id);
        }

        @Override
        public void deleteCartProductById(Long id) {
                cartProductRepository.deleteCartProductById(id);
        }
}
