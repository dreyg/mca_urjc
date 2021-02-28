package es.urjc.code.ejem1.service;


import es.urjc.code.ejem1.domain.ProductEventDTO;
import es.urjc.code.ejem1.domain.ProductPublishService;
import org.springframework.context.ApplicationEventPublisher;

public class ProductPublishServiceImpl implements ProductPublishService {

    private ApplicationEventPublisher applicationEventPublisher;

    public ProductPublishServiceImpl(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publishEvent(ProductEventDTO productEventDTO) {
        applicationEventPublisher.publishEvent(productEventDTO);
    }

}
