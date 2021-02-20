package es.codeurjc.shoppingCart.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {


    ProductDto save(ProductDto product);

    List<ProductDto> findAllProducts();

    Optional<ProductDto> findProductById(Long id);

    void deleteProductById(Long id);

}
