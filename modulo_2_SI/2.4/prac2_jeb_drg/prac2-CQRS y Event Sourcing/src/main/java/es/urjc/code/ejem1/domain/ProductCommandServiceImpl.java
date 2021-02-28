package es.urjc.code.ejem1.domain;

import org.modelmapper.ModelMapper;

import java.util.Collection;

public class ProductCommandServiceImpl implements ProductCommandService {

	private ProductPublishService productPublishService;
	ModelMapper mapper = new ModelMapper();
	private ProductRepository repository;

	public ProductCommandServiceImpl(ProductPublishService productPublishService, ProductRepository repository) {
		this.productPublishService = productPublishService;
		this.repository = repository;
	}


	@Override
	public void createProduct(ProductDTO productDTO) {
		ProductEventDTO productEventDTO = mapper.map(productDTO, ProductEventDTO.class);
		productEventDTO.setTypeOperation(1);
		productPublishService.publishEvent(productEventDTO);
	}

	@Override
	public void deleteProduct(Long id) {
		FullProductDTO product = repository.findById(id);
		ProductEventDTO productEventDTO = mapper.map(product, ProductEventDTO.class);
		productEventDTO.setTypeOperation(2);
		productPublishService.publishEvent(productEventDTO);
	}

}
