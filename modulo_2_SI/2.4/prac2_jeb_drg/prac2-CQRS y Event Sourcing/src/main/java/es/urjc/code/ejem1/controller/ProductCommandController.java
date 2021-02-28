package es.urjc.code.ejem1.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;

import es.urjc.code.ejem1.domain.ProductCommandService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.ejem1.domain.FullProductDTO;
import es.urjc.code.ejem1.domain.ProductDTO;
import es.urjc.code.ejem1.domain.ProductQueryService;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

	private ProductCommandService productCommandService;
	private ModelMapper mapper = new ModelMapper();

	public ProductCommandController(ProductCommandService productCommandService) {
		this.productCommandService = productCommandService;
	}

	@PostMapping
	public void createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
		productCommandService.createProduct(productDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productCommandService.deleteProduct(id);
	}

}
