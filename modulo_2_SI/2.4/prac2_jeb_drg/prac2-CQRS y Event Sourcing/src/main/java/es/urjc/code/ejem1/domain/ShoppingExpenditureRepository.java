package es.urjc.code.ejem1.domain;

import java.util.List;

public interface ShoppingExpenditureRepository {

	ShoppingExpenditureDTO save(ShoppingExpenditureDTO shoppingExpenditureDTO);

	List<ShoppingExpenditureDTO> findAll();

	ShoppingExpenditureDTO findById(Long id);

}
