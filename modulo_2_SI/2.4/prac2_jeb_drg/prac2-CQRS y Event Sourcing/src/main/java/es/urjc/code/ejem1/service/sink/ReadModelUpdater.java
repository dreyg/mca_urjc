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

    @EventListener
    public void addCompletedShoppingCartExpenditure(ShoppingExpenditureDTO shoppingExpenditureDTO) {
        shoppingExpenditureRepository.save(shoppingExpenditureDTO);
    }

    @EventListener
    public void operationsShoppingCart(ShoppingCartEventDTO shoppingCartEventDTO) {
        FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCartEventDTO, FullShoppingCartDTO.class);
        switch (shoppingCartEventDTO.getTypeOperation()){
            case 1:
                shoppingCartRepository.save(fullShoppingCartDTO);
                break;
            case 2:
                shoppingCartRepository.deleteById(fullShoppingCartDTO.getId());
                break;
            case 3:
                shoppingCartRepository.save(fullShoppingCartDTO);
                break;
        }

    }

}
