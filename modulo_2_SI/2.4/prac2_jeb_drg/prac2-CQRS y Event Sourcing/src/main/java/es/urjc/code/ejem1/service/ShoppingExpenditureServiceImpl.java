package es.urjc.code.ejem1.service;

import es.urjc.code.ejem1.domain.ShoppingExpenditureDTO;
import es.urjc.code.ejem1.domain.ShoppingExpenditureService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ShoppingExpenditureServiceImpl implements ShoppingExpenditureService {

	private ApplicationEventPublisher applicationEventPublisher;

	public ShoppingExpenditureServiceImpl(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}



	@Override
	public void publishEvent(ShoppingExpenditureDTO shoppingExpenditureDTO) {
		applicationEventPublisher.publishEvent(shoppingExpenditureDTO);
	}
}
