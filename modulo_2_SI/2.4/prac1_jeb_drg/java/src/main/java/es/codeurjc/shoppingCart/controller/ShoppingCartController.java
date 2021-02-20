package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import es.codeurjc.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCart;


    @PostMapping("/api/shoppingcarts")
    public ResponseEntity<ShoppingCartResponseDto> createShoppingCart(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto){

        ShoppingCartDto shoppingCartDto = shoppingCart.save(shoppingCartRequestDto);

        ShoppingCartResponseDto responseShoppingCartDto = new ShoppingCartResponseDto(
                shoppingCartDto.getId(),
                shoppingCartDto.getState(),
                shoppingCartDto.getProducts());


        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(shoppingCartDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseShoppingCartDto);
    }

    /*@PatchMapping("/api/shoppingcarts/{id}")
    public ResponseEntity<ShoppingCartResponseDto> updateShoppingCart(){


        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(fullShoppingCart.getId()).toUri();

        return ResponseEntity.created(location).body(responseShoppingCartDto);
    }*/

    /*@GetMapping("/api/shoppingcarts/{id}")
    public ResponseEntity<ShoppingCartResponseDto> getShoppingCart(){
        return shoppingCart.findById(id).orElseThrow();
    }*/

    /*@DeleteMapping("/api/shoppingcarts/{id}")
    public void  deleteShoppingCartById(){


        ProductResponseDto comment = shoppingCart.findById(productId).orElseThrow();

        shoppingCart.deleteById(productId);

    }*/

    /*@PostMapping("/api/shoppingcarts/{cart_id}/product/{prod_id}/quantity/{prod_quantity}")
    public ResponseEntity<ShoppingCartResponseDto> updateShoppingCartProduct(){

        FullProductDto fullProduct = shoppingCart.save(product);

        // Transform fullBook into BookResponseDto
        ProductResponseDto responseProductDto = new ProductResponseDto(
                fullProduct.getId(),
                fullProduct.getName(),
                fullProduct.getDescription());

        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(fullProduct.getId()).toUri();

        return ResponseEntity.created(location).body(ShoppingCartResponseDto);

    }*/

    /*@DeleteMapping("/api/shoppingcarts/:cart_id/product/:prod_id")
    public void deleteProductInShoppingCart(){

        ProductResponseDto comment = shoppingCart.findById(productId).orElseThrow();

        shoppingCart.deleteById(productId);

    }*/


}
