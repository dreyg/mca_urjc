package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.domain.ProductQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;


@RestController
@RequestMapping("/api/products")
public class ProductQueryController {

	private ProductQueryService productQueryService;
	private ModelMapper mapper = new ModelMapper();

	public ProductQueryController(ProductQueryService productQueryService) {
		this.productQueryService = productQueryService;
	}

	@GetMapping
	public Collection<ProductResponseDTO> getProducts() {
		return Arrays.asList(mapper.map(productQueryService.getProducts(), ProductResponseDTO[].class));
	}

	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable Long id) {
		return mapper.map(productQueryService.getProduct(id), ProductResponseDTO.class);
	}

}
