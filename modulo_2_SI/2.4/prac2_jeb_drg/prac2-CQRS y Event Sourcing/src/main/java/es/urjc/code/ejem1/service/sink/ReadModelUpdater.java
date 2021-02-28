package es.urjc.code.ejem1.service.sink;

import es.urjc.code.ejem1.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class ReadModelUpdater {

    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private ShoppingExpenditureRepository shoppingExpenditureRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @EventListener
    public void addCompletedShoppingCartExpenditure(ShoppingExpenditureDTO shoppingExpenditureDTO) {
        shoppingExpenditureRepository.save(shoppingExpenditureDTO);
    }

    @EventListener
    public void operationsShoppingCart(ShoppingCartEventDTO shoppingCartEventDTO) {
        FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCartEventDTO, FullShoppingCartDTO.class);
        switch (shoppingCartEventDTO.getTypeOperation()) {
            case 1:
                shoppingCartRepository.save(fullShoppingCartDTO);
                break;
            case 2:
                shoppingCartRepository.deleteById(fullShoppingCartDTO.getId());
                break;
        }
    }

    @EventListener
    public void operationsProduct(ProductEventDTO productEventDTO) {
        FullProductDTO fullProductDTO = mapper.map(productEventDTO, FullProductDTO.class);
        switch (productEventDTO.getTypeOperation()) {
            case 1:
                productRepository.save(fullProductDTO);
                break;
            case 2:
                productRepository.deleteById(fullProductDTO.getId());
                break;
        }
    }

}
