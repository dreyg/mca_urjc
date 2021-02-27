package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartService;
import es.urjc.code.ejem1.domain.ShoppingExpenditureService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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
