package es.codeurjc.shoppingCart.service;

import es.codeurjc.shoppingCart.controller.ProductRequestDto;
import es.codeurjc.shoppingCart.controller.ProductResponseDto;
import es.codeurjc.shoppingCart.domain.FullProductDto;
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

    public FullProductDto save(ProductRequestDto product) {

        ProductDto productDto = new ProductDto(
                product.getName(),
                product.getName()
        );

        return productUseCase.createProduct(productDto);
    }


    public Collection<ProductResponseDto> findAll() {
        return productUseCase
                .findAllProducts()
                .stream()
                .map(ProductResponseDto::fromFullProductDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponseDto> findById(Long id) {
        return productUseCase.findProductById(id).map(ProductResponseDto::fromFullProductDto);
    }

    public void deleteById(Long id) {
        productUseCase.deleteProductById(id);
    }

}
