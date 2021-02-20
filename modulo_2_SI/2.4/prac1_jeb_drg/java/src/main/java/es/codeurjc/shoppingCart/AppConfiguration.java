package es.codeurjc.shoppingCart;


import es.codeurjc.shoppingCart.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ProductUseCase productUserCase(ProductRepository productRepositoryAdapter){
        return new ProductUseCaseImpl(productRepositoryAdapter);
    }

    @Bean
    public ShoppingCartUseCase shoppingCartUseCase(ShoppingCartRepository shoppingCartRepositoryAdapter){
        return new ShoppingCartUseCaseImpl(shoppingCartRepositoryAdapter);
    }
}
