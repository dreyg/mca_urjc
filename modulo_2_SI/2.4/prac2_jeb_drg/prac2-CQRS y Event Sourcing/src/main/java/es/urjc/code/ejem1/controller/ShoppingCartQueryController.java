package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.domain.ShoppingCartCommandService;
import es.urjc.code.ejem1.domain.ShoppingCartQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartQueryController {

	private ShoppingCartQueryService shoppingCartQueryService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryController(ShoppingCartQueryService shoppingCartQueryService) {
		this.shoppingCartQueryService = shoppingCartQueryService;
	}

	@GetMapping("/{id}")
	public ShoppingCartResponseDTO getShoppingCart(@PathVariable Long id) {
		return mapper.map(shoppingCartQueryService.getShoppingCart(id), ShoppingCartResponseDTO.class);
	}


}
