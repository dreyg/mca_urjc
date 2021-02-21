package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import es.codeurjc.shoppingCart.service.CartProductService;
import es.codeurjc.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCart;

    @Autowired
    private CartProductService cartProduct;


    @PostMapping("/api/shoppingcarts")
    public ResponseEntity<ShoppingCartResponseDto> createShoppingCart(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto){

        ShoppingCartDto shoppingCartDto = shoppingCart.save(shoppingCartRequestDto);

        ShoppingCartResponseDto responseShoppingCartDto = new ShoppingCartResponseDto(
                shoppingCartDto.getId(),
                shoppingCartDto.getState(),
                shoppingCartDto.getCartProductDtos());


        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(shoppingCartDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseShoppingCartDto);
    }

    /*
    @PatchMapping("/api/shoppingcarts/{id}")
    public ResponseEntity<ShoppingCartResponseDto> updateShoppingCart(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto){

        ShoppingCartDto shoppingCartDto = shoppingCart.update(shoppingCartRequestDto);

        ShoppingCartResponseDto responseShoppingCartDto = new ShoppingCartResponseDto(
                shoppingCartDto.getId(),
                shoppingCartDto.getState(),
                shoppingCartDto.getCartProductDtos());

        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(shoppingCartDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseShoppingCartDto);
    }*/

    @GetMapping("/api/shoppingcarts/{id}")
    public ShoppingCartResponseDto getShoppingCart(@PathVariable long id){
        return shoppingCart.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/shoppingCarts/{id}")
    public void  deleteShoppingCartById(@PathVariable long id){
        ShoppingCartResponseDto shoppingCartResponseDto = shoppingCart.findById(id).orElseThrow();

        shoppingCart.deleteById(shoppingCartResponseDto.getId());

    }

    /*@PostMapping("/api/shoppingcarts/{cart_id}/product/{prod_id}/quantity/{prod_quantity}")
    public ShoppingCartResponseDto updateShoppingCartProduct(@PathVariable long cartId,
                                                                             @PathVariable long prodId,
                                                                             @PathVariable long prodQuantity){

        Optional<ShoppingCartDto> shoppingCartDto = shoppingCart.findByIdDto(cartId);
        shoppingCartDto = cartProduct.updateShoppingCart(shoppingCartDto,prodId,prodQuantity);

        return shoppingCart.findById(cartId).orElseThrow();
    }

    @DeleteMapping("/api/shoppingcarts/:cart_id/product/:prod_id")
    public void deleteProductInShoppingCart(){

        ProductResponseDto comment = shoppingCart.findById(productId).orElseThrow();

        shoppingCart.deleteById(productId);

    }
*/

}
