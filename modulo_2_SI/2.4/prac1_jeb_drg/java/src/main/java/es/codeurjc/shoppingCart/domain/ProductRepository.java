package es.codeurjc.shoppingCart.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {


    FullProductDto save(FullProductDto product);

    List<FullProductDto> findAllProducts();

    Optional<FullProductDto> findProductById(Long id);

    void deleteProductById(Long id);

}
