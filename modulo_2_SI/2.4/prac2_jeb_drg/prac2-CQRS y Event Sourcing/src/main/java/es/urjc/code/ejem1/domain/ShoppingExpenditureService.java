package es.urjc.code.ejem1.domain;

import java.util.Collection;

public interface ShoppingExpenditureService {

    void publishEvent (ShoppingExpenditureDTO shoppingExpenditureDTO);
    Collection<ShoppingExpenditureDTO> getShoppingCartExpenditure();

}
