package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.ProductDto;
import es.codeurjc.shoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
public class ProductController {

    @Autowired
    private ProductService products;

    @GetMapping("/api/products/")
    public Collection<ProductResponseDto> getProducts() {
        return products.findAll();
    }

    @PostMapping("/api/product/")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto product) {

        ProductDto productDto = products.save(product);

        ProductResponseDto responseProductDto = new ProductResponseDto(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription());

        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(productDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseProductDto);
    }

    @GetMapping("/api/products/{id}")
    public ProductResponseDto getProduct(@PathVariable long id) {

        ProductDto productDto = products.findById(id).orElseThrow();

        return new ProductResponseDto(productDto.getId(),productDto.getName(),productDto.getDescription());
    }

    @DeleteMapping("/api/products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        products.deleteById(productId);
    }

}
