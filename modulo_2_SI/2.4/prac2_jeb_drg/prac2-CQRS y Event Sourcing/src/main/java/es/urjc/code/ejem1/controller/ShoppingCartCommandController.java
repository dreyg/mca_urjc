package es.urjc.code.ejem1.controller;

import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.ejem1.domain.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartCommandService;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartCommandController {

	private ShoppingCartCommandService shoppingCartCommandService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartCommandController(ShoppingCartCommandService shoppingCartCommandService) {
		this.shoppingCartCommandService = shoppingCartCommandService;
	}

	@PostMapping
	public void createShoppingCart() {
		shoppingCartCommandService.createShoppingCart();
	}

	@DeleteMapping("/{id}")
	public void deleteShoppingCart(@PathVariable Long id) {
		shoppingCartCommandService.deleteShoppingCart(id);
	}

	@DeleteMapping("/{idShoppingCart}/product/{idProduct}")
	public void deleteProductInShoppingCart(
			@PathVariable Long idShoppingCart,
			@PathVariable Long idProduct) {
		shoppingCartCommandService.deleteProduct(idShoppingCart, idProduct);
	}

	@PostMapping("/{idShoppingCart}/product/{idProduct}/quantity/{quantity}")
	public void addProductToShoppingCart(
	        @PathVariable Long idShoppingCart,
	        @PathVariable Long idProduct,
	        @PathVariable int quantity) {

		shoppingCartCommandService.addProduct(idShoppingCart, idProduct, quantity);
	}



	@PatchMapping("/{id}")
	public void updateShoppingCart(
	        @PathVariable Long id,
	        @Validated @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
		shoppingCartCommandService.updateShoppingCart(id,
		        mapper.map(shoppingCartRequestDTO, ShoppingCartDTO.class));
	}

}
