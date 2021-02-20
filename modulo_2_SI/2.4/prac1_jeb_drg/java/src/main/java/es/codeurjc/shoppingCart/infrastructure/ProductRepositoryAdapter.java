package es.codeurjc.shoppingCart.infrastructure;

import es.codeurjc.shoppingCart.domain.ProductDto;
import es.codeurjc.shoppingCart.domain.ProductRepository;
import es.codeurjc.shoppingCart.infrastructure.model.ProductEntity;
import es.codeurjc.shoppingCart.infrastructure.repository.ProductJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private ProductJpaRepository productJpaRepository;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository){
        this.productJpaRepository = productJpaRepository;
    }


    @Override
    public ProductDto save(ProductDto product) {

        ProductEntity productEntity = new ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription());

        ProductEntity savedProductEntity = productJpaRepository.save(productEntity);

        return toProductDto(savedProductEntity);
    }



    @Override
    public List<ProductDto> findAllProducts() {

        List<ProductEntity> products = productJpaRepository.findAll();

        return products
                .stream()
                .map(ProductRepositoryAdapter::toProductDto)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<ProductDto> findProductById(Long id) {

        Optional<ProductEntity> maybeAProduct = productJpaRepository.findById(id);

        return maybeAProduct.map(ProductRepositoryAdapter::toProductDto);

    }

    @Override
    public void deleteProductById(Long id) {

        productJpaRepository.deleteById(id);

    }



    private static ProductDto toProductDto(ProductEntity product){

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription());

    }

}
