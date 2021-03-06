package es.urjc.code.ejem1.infrastructure;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpringDataJPAShoppingCartRepositoryAdapter implements ShoppingCartRepository {

	private SpringDataJPAShoppingCartRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAShoppingCartRepositoryAdapter(SpringDataJPAShoppingCartRepository repository) {
		this.repository = repository;
	}

	@Override
	public FullShoppingCartDTO findById(Long id) {
		return mapper.map(repository.findById(id).orElseThrow(ShoppingCartNotFoundException::new),
		        FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart) {
		ShoppingCartEntity shoppingCartEntity = mapper.map(shoppingCart, ShoppingCartEntity.class);
		repository.save(shoppingCartEntity);

		return findById(shoppingCartEntity.getId());
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<FullShoppingCartDTO> findAll() {
		List<ShoppingCartEntity> shoppingCartEntities = repository.findAll();
		return shoppingCartEntities
				.stream()
				.map(element -> mapper.map(element, FullShoppingCartDTO.class))
				.collect(Collectors.toList());
	}


}
