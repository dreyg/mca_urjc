package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.domain.ShoppingExpenditureService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartExpenditureController {

	private ShoppingExpenditureService shoppingExpenditureService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartExpenditureController(ShoppingExpenditureService shoppingExpenditureService) {
		this.shoppingExpenditureService = shoppingExpenditureService;
	}

	@GetMapping("/cartexpenditure")
	public List<ShoppingCartExpenditureResponseDTO> getShoppingCartExpenditure() {
		return Arrays.asList(mapper.map(shoppingExpenditureService.getShoppingCartExpenditure(), ShoppingCartExpenditureResponseDTO[].class));
	}
}
