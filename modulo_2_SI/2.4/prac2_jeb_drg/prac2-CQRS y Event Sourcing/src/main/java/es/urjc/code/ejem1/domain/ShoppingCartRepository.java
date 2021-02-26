package es.urjc.code.ejem1.domain;

import java.util.List;

public interface ShoppingCartRepository {
	FullShoppingCartDTO findById(Long id);

	FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

	void deleteById(Long id);

	List<FullShoppingCartDTO> findAll();
}
