package es.urjc.code.ejem1.domain;

public interface ShoppingCartCommandService {

	public void createShoppingCart();

	public void deleteShoppingCart(Long id);

	public void deleteProduct(Long idShoppingCart, Long idProduct);

	public void updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

	public void addProduct(Long idShoppingCart, Long idProduct, int nProducts);

	public void addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity);

}
