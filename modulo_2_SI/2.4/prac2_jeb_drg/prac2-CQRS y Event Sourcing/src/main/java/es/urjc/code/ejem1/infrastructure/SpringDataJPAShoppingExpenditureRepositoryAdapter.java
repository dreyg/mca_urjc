package es.urjc.code.ejem1.infrastructure;

import es.urjc.code.ejem1.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpringDataJPAShoppingExpenditureRepositoryAdapter implements ShoppingExpenditureRepository {

	private SpringDataJPAShoppingExpenditureRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAShoppingExpenditureRepositoryAdapter(SpringDataJPAShoppingExpenditureRepository repository) {
		this.repository = repository;
	}

	@Override
	public ShoppingExpenditureDTO save(ShoppingExpenditureDTO shoppingExpenditureDTO) {
		ShoppingExpenditureEntity shoppingExpenditureEntity = mapper.map(shoppingExpenditureDTO,ShoppingExpenditureEntity.class);
		repository.save(shoppingExpenditureEntity);
		return findById(shoppingExpenditureEntity.getId());
	}

	@Override
	public Collection<ShoppingExpenditureDTO> findAll() {
		Collection<ShoppingExpenditureEntity> shoppingExpenditureEntities = repository.findAll();
		return shoppingExpenditureEntities
				.stream()
				.map(element -> mapper.map(element, ShoppingExpenditureDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ShoppingExpenditureDTO findById(Long id) {
		return mapper.map(repository.findById(id).orElseThrow(ShoppingExpenditureNotFoundException::new),
				ShoppingExpenditureDTO.class);
	}

}
