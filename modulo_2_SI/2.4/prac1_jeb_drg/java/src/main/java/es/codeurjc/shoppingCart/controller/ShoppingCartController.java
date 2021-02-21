package es.codeurjc.shoppingCart.controller;

import es.codeurjc.shoppingCart.domain.CartProductDto;
import es.codeurjc.shoppingCart.domain.ProductDto;
import es.codeurjc.shoppingCart.domain.ShoppingCartDto;
import es.codeurjc.shoppingCart.service.CartProductService;
import es.codeurjc.shoppingCart.service.ProductService;
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

    @Autowired
    private ProductService productService;


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


    @PatchMapping("/api/shoppingcarts/{id}")
    public ResponseEntity<ShoppingCartResponseDto> finishShoppingCart(@PathVariable long id){

        ShoppingCartResponseDto shoppingCartResponseDtoDto = shoppingCart.findById(id).orElseThrow();

        // ResponseDto to RequestDto

        ShoppingCartDto shoppingCartDto = shoppingCart.update(shoppingCartResponseDtoDto);

        ShoppingCartResponseDto responseShoppingCartDto = new ShoppingCartResponseDto(
                shoppingCartDto.getId(),
                shoppingCartDto.getState(),
                shoppingCartDto.getCartProductDtos());

        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(shoppingCartDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseShoppingCartDto);
    }

    @GetMapping("/api/shoppingcarts/{id}")
    public ShoppingCartResponseDto getShoppingCart(@PathVariable long id){
        return shoppingCart.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/shoppingCarts/{id}")
    public void  deleteShoppingCartById(@PathVariable long id){
        ShoppingCartResponseDto shoppingCartResponseDto = shoppingCart.findById(id).orElseThrow();

        shoppingCart.deleteById(shoppingCartResponseDto.getId());

    }


    @PostMapping("/api/shoppingcarts/{cartId}/product/{prodId}/quantity/{prodQuantity}")
    public ShoppingCartResponseDto updateShoppingCartProduct(@PathVariable long cartId,
                                                                             @PathVariable long prodId,
                                                                             @PathVariable Integer prodQuantity){


        // ir a bdd de productos a el producto ID que nos viene en la request
        Optional<ProductDto> productDto = productService.findById(prodId);
        // si viene, se lo setteamos en la llamada de abajo

        CartProductDto cartProductDto = cartProduct.save(new CartProductRequestDto(prodQuantity,productDto.get()));

        shoppingCart.saveCartProduct(cartProductDto, cartId);
        return shoppingCart.findById(cartId).orElseThrow();
    }


    @DeleteMapping("/api/shoppingcarts/cartId/product/prodId")
    public void deleteProductInShoppingCart(@PathVariable long cartId,
                                            @PathVariable long prodId){

        ShoppingCartResponseDto shoppingCartResponseDto = shoppingCart.findById(cartId).orElseThrow();

        shoppingCart.deleteById(prodId);

    }


}
