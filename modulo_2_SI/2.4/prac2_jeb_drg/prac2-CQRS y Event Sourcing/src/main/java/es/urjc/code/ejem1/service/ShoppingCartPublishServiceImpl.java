package es.urjc.code.ejem1.service;


import es.urjc.code.ejem1.domain.ShoppingCartEventDTO;
import es.urjc.code.ejem1.domain.ShoppingCartPublishService;
import org.springframework.context.ApplicationEventPublisher;

public class ShoppingCartPublishServiceImpl implements ShoppingCartPublishService {

    private ApplicationEventPublisher applicationEventPublisher;

    public ShoppingCartPublishServiceImpl(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publishEvent(ShoppingCartEventDTO shoppingCartEventDTO) {
        applicationEventPublisher.publishEvent(shoppingCartEventDTO);
    }

}
