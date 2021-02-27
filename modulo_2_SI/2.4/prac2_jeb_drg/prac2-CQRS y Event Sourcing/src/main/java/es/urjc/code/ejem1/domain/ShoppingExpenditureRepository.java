package es.urjc.code.ejem1.domain;

import java.util.Collection;

public interface ShoppingExpenditureRepository {

	ShoppingExpenditureDTO save(ShoppingExpenditureDTO shoppingExpenditureDTO);

	Collection<ShoppingExpenditureDTO> findAll();

	ShoppingExpenditureDTO findById(Long id);

}
