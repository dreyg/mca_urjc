package es.urjc.code.ejem1.service.sink;

import es.urjc.code.ejem1.domain.ShoppingExpenditure;
import es.urjc.code.ejem1.domain.ShoppingExpenditureDTO;
import es.urjc.code.ejem1.domain.ShoppingExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReadModelUpdater {

    /*private final JdbcTemplate jdbcTemplate;

   ReadModelUpdater(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Autowired
    private ShoppingExpenditureRepository shoppingExpenditureRepository;

    @EventListener
    public void addCompletedShoppingCartExpenditure(ShoppingExpenditureDTO shoppingExpenditureDTO) {
        /*jdbcTemplate.update("INSERT INTO ShoppingCartEntity(ID, CARD_ID, AMOUNT) VALUES (?,?,?)",
                UUID.randomUUID(), event.getId(), event.getPrice());*/
        shoppingExpenditureRepository.save(shoppingExpenditureDTO);


    }

}
