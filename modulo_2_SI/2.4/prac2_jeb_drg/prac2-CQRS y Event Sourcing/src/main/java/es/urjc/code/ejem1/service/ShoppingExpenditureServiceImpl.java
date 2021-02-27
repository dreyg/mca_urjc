package es.urjc.code.ejem1.service;

import es.urjc.code.ejem1.domain.ShoppingExpenditureDTO;
import es.urjc.code.ejem1.domain.ShoppingExpenditureRepository;
import es.urjc.code.ejem1.domain.ShoppingExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShoppingExpenditureServiceImpl implements ShoppingExpenditureService {


	private ApplicationEventPublisher applicationEventPublisher;
	@Autowired private ShoppingExpenditureRepository repository;

	public ShoppingExpenditureServiceImpl(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public void publishEvent(ShoppingExpenditureDTO shoppingExpenditureDTO) {
		applicationEventPublisher.publishEvent(shoppingExpenditureDTO);
	}

	@Override
	public Collection<ShoppingExpenditureDTO> getShoppingCartExpenditure() {
		return repository.findAll();
	}

}
