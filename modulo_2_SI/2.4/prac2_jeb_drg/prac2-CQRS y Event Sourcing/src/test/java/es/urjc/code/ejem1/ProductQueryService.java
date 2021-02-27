package es.urjc.code.ejem1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import es.urjc.code.ejem1.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.modelmapper.ModelMapper;

@TestMethodOrder(OrderAnnotation.class)
public class ProductQueryService {

	private ProductRepository productRepository;
	private ProductQueryServiceImpl productQueryService;
	private ProductCommandServiceImpl productCommandService;

	private ModelMapper mapper = new ModelMapper();

	private static FullProductDTO createdProduct;

	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		productCommandService = new ProductCommandServiceImpl(productRepository);
		productQueryService = new ProductQueryServiceImpl(productRepository);
	}

	@Test
	@Order(1)
	void productCanBeAdded() {
		Product product = new Product(
		        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
		        49.99);

		ProductDTO productDTO = mapper.map(product, ProductDTO.class);

		createdProduct = productCommandService.createProduct(productDTO);
		verify(productRepository).save(createdProduct);
	}

	@Test
	@Order(2)
	void productCanBeDeleted() {
		productCommandService.deleteProduct(createdProduct.getId());
		verify(productRepository).deleteById(createdProduct.getId());
	}
}
