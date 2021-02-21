package es.codeurjc.shoppingCart.service;

import es.codeurjc.shoppingCart.controller.ProductRequestDto;
import es.codeurjc.shoppingCart.controller.ProductResponseDto;
import es.codeurjc.shoppingCart.domain.ProductDto;
import es.codeurjc.shoppingCart.domain.ProductUseCase;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductUseCase productUseCase;

    public ProductService(ProductUseCase productUseCase){
        this.productUseCase = productUseCase;
    }

    public ProductDto save(ProductRequestDto product) {

        ProductDto productDto = new ProductDto(
                product.getName(),
                product.getDescription()
        );

        return productUseCase.createProduct(productDto);
    }


    public Collection<ProductResponseDto> findAll() {
        return productUseCase
                .findAllProducts()
                .stream()
                .map(ProductResponseDto::fromProductDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(Long id) {
        return productUseCase.findProductById(id);
    }

    public void deleteById(Long id) {
        productUseCase.deleteProductById(id);
    }

}
