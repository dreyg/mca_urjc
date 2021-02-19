package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.FullProductDto;
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

    @PostMapping("/api/product/")
    public ResponseEntity<ProductResponseDto> createBook(@RequestBody ProductRequestDto product) {

        FullProductDto fullProduct = products.save(product);

        // Transform fullBook into BookResponseDto
        ProductResponseDto responseProductDto = new ProductResponseDto(
                fullProduct.getId(),
                fullProduct.getName(),
                fullProduct.getDescription());

        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(fullProduct.getId()).toUri();

        return ResponseEntity.created(location).body(responseProductDto);
    }


    @GetMapping("/api/products/")
    public Collection<ProductResponseDto> getProducts() {
        return products.findAll();
    }

    @GetMapping("/api/products/{id}")
    public ProductResponseDto getProduct(@PathVariable long id) {

        return products.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/productss/{productId}")
    public void deleteProduct(@PathVariable Long productId) {

        ProductResponseDto comment = products.findById(productId).orElseThrow();

        products.deleteById(productId);

    }

}
