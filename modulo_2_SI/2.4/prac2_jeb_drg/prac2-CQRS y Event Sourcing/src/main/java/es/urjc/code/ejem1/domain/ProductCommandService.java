package es.urjc.code.ejem1.domain;


public interface ProductCommandService {

	public FullProductDTO createProduct(ProductDTO productDTO);
	public FullProductDTO deleteProduct(Long id);
}
