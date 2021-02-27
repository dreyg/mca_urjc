package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.*;
import es.urjc.code.ejem1.infrastructure.SpringDataJPAShoppingExpenditureRepositoryAdapter;
import es.urjc.code.ejem1.service.ShoppingExpenditureServiceImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import es.urjc.code.ejem1.infrastructure.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.ejem1.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
	        SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
			ApplicationEventPublisher applicationEventPublisher) {
		return new ShoppingCartServiceImpl(
		        shoppingCartRepositoryAdapter,
		        productRepositoryAdapter,
		        new ValidationServiceImpl(),
				new ShoppingExpenditureServiceImpl(applicationEventPublisher));
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}

	// TODO inicializar shoppingExpenditureService
	/*@Bean
	public ShoppingExpenditureService shoppingExpenditureService(SpringDataJPAShoppingExpenditureRepositoryAdapter repositoryAdapter) {
		return new ShoppingExpenditureServiceImpl(repositoryAdapter);
	}*/

}
