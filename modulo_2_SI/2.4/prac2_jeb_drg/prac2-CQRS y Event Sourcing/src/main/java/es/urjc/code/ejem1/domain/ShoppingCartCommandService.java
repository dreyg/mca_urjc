package es.urjc.code.ejem1.domain;

import java.util.List;

public interface ShoppingCartCommandService {

	public FullShoppingCartDTO createShoppingCart();

	public FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

	public FullShoppingCartDTO deleteShoppingCart(Long id);

	public FullShoppingCartDTO addProduct(Long idShoppingCart, Long idProduct, int nProducts);

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity);

	public FullShoppingCartDTO deleteProduct(Long idShoppingCart, Long idProduct);

}
