package es.codeurjc.shoppingCart.domain;


import java.util.Collection;
import java.util.Optional;

public interface ProductUseCase {

    public ProductDto createProduct(ProductDto product);

    public Collection<ProductDto> findAllProducts();

    public Optional<ProductDto> findProductById(Long id);

    public void deleteProductById(Long id);

}
