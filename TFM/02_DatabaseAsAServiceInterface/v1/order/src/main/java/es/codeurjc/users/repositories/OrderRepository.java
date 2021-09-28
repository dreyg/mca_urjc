package es.codeurjc.users.repositories;

import es.codeurjc.users.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Integer id);

}
