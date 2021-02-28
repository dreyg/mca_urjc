package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.*;
import es.urjc.code.ejem1.domain.ShoppingCartCommandServiceImpl;
import es.urjc.code.ejem1.service.ProductPublishServiceImpl;
import es.urjc.code.ejem1.service.ShoppingCartPublishServiceImpl;
import es.urjc.code.ejem1.service.ShoppingExpenditureServiceImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import es.urjc.code.ejem1.infrastructure.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.ejem1.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartCommandService shoppingCartCommandService(
			SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
			SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
			ApplicationEventPublisher applicationEventPublisher) {
		return new ShoppingCartCommandServiceImpl(
				shoppingCartRepositoryAdapter,
				productRepositoryAdapter,
				new ValidationServiceImpl(),
				new ShoppingExpenditureServiceImpl(applicationEventPublisher),
				new ShoppingCartPublishServiceImpl(applicationEventPublisher));
	}

	@Bean
	public ShoppingCartQueryService shoppingCartQueryService(
			SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
			SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
			ApplicationEventPublisher applicationEventPublisher) {
		return new ShoppingCartQueryServiceImpl(
				shoppingCartRepositoryAdapter,
				productRepositoryAdapter,
				new ValidationServiceImpl(),
				new ShoppingExpenditureServiceImpl(applicationEventPublisher));
	}

	@Bean
	public ProductQueryService productQueryService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductQueryServiceImpl(repositoryAdapter);
	}

	@Bean
	public ProductCommandService productCommandService(SpringDataJPAProductRepositoryAdapter repositoryAdapter, ApplicationEventPublisher applicationEventPublisher) {
		return new ProductCommandServiceImpl(new ProductPublishServiceImpl(applicationEventPublisher), repositoryAdapter);
	}

}
