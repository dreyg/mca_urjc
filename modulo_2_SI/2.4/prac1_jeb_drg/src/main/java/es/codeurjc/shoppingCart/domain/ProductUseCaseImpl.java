package es.codeurjc.shoppingCart.domain;


import java.util.Collection;
import java.util.Optional;

public class ProductUseCaseImpl implements ProductUseCase {


        private ProductRepository productRepository;

        public ProductUseCaseImpl(ProductRepository repository){
                this.productRepository = repository;
        }

        @Override
        public FullProductDto createProduct(ProductDto productDto) {
                FullProductDto product = new FullProductDto(productDto.getName(), productDto.getDescription());

                FullProductDto fullProduct = productRepository.save(product);
                return fullProduct;
        }


        @Override
        public Collection<FullProductDto> findAllProducts() {
                return productRepository.findAllProducts();
        }

        @Override
        public Optional<FullProductDto> findProductById(Long id) {
                return productRepository.findProductById(id);
        }

        @Override
        public void deleteProductById(Long id) {
                productRepository.deleteProductById(id);
        }
}
