package es.codeurjc.shoppingCart;


import es.codeurjc.shoppingCart.domain.ProductRepository;
import es.codeurjc.shoppingCart.domain.ProductUseCase;
import es.codeurjc.shoppingCart.domain.ProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ProductUseCase productUserCase(ProductRepository productRepositoryAdapter){
        return new ProductUseCaseImpl(productRepositoryAdapter);
    }
}
