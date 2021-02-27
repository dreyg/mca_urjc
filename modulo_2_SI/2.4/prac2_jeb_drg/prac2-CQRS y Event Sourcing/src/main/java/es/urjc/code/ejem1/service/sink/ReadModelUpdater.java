package es.urjc.code.ejem1.service.sink;

import es.urjc.code.ejem1.domain.ShoppingExpenditure;
import es.urjc.code.ejem1.domain.ShoppingExpenditureDTO;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReadModelUpdater {

    private final JdbcTemplate jdbcTemplate;

   ReadModelUpdater(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void addWithdrawalOnCardWithdrawn(ShoppingExpenditureDTO event) {
        jdbcTemplate.update("INSERT INTO ShoppingCartEntity(ID, CARD_ID, AMOUNT) VALUES (?,?,?)",
                UUID.randomUUID(), event.getId(), event.getPrice());
    }

}
