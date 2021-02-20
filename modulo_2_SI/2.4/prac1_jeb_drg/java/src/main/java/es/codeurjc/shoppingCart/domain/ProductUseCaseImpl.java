package es.codeurjc.shoppingCart.domain;


import java.util.Collection;
import java.util.Optional;

public class ProductUseCaseImpl implements ProductUseCase {


        private ProductRepository productRepository;

        public ProductUseCaseImpl(ProductRepository repository){
                this.productRepository = repository;
        }

        @Override
        public ProductDto createProduct(ProductDto productDto) {

                ProductDto product = productRepository.save(productDto);
                return product;
        }


        @Override
        public Collection<ProductDto> findAllProducts() {
                return productRepository.findAllProducts();
        }

        @Override
        public Optional<ProductDto> findProductById(Long id) {
                return productRepository.findProductById(id);
        }

        @Override
        public void deleteProductById(Long id) {
                productRepository.deleteProductById(id);
        }
}
