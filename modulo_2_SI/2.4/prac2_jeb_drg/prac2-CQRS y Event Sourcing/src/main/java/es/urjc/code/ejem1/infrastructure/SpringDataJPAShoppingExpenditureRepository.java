package es.urjc.code.ejem1.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingExpenditureRepository extends JpaRepository<ShoppingExpenditureEntity, Long> {

}
